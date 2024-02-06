package com.example.ch16_provider

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        contentResolver.query(
            Uri.parse("content://com.example.test_provider"),
            null, null, null, null)


        val requestGalleryLauncher = registerForActivityResult(
                ActivityResultContracts.StartActivityForResult())
        {
            try {
                // inSampleSize 비율 계산, 지정
                val calRatio = calculateInSampleSize(it !!. data !!. data !! ,
                    resources.getDimensionPixelSize(R.dimen.imgSize),
                    resources.getDimensionPixelSize(R.dimen.imgSize))
                val option = BitmapFactory.Options()
                option.inSampleSize=calRatio

                // 이미지 로당
                var inputStream = contentResolver.openInputStream(it !!. data !!. data !! )
                val bitmap = BitmapFactory.decodeStream(inputStream, null, option)
                inputStream !!. close()
                inputStream = null
                bitmap ?. let {
                    binding.galleryResult.setImageBitmap(bitmap)
                } ?: let {
                    Log.d("kkang", "bitmap null")
                }
            } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }



        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        intent.type = "image/*"
        requestGalleryLauncher. launch(intent)
    }
}

private fun calculateInSampleSize(fileUri: Uri, reqWidth: Int, reqHeight: Int): Int {
    val options = BitmapFactory.Options()
    options.inJustDecodeBounds = true // true로 옵션만 설정
    try {
        var inputStream = contentResolver.openInputStream(fileUri)
        BitmapFactory.decodeStream(inputStream, null, options) // 이미지 정보들이 option에 설정
        inputStream!!.close()
        inputStream = null
    } catch (e: Exception) {
        e.printStackTrace()
    }
    val (height: Int, width: Int) = options.run { outHeight to outWidth }
    var inSampleSize = 1
    // inSampleSize 비율 계산
    if (height > reqHeight || width > reqwidth) {
        val halfHeight: Int = height / 2
        val halfWidth: Int = width / 2
        while (halfHeight / inSampleSize >= reqHeight &&
            halfWidth / inSampleSize >= reqWidth
        ) {
            inSampleSize *= 2
        }
    }
    return inSampleSize

}