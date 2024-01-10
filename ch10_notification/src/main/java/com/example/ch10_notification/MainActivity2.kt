package com.example.ch10_notification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        /*
        val requestPermissionLauncher = registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) {isGranted ->
            if (isGranted) {
                Log.d("event", "callback, granted..")
            } else {
                Log.d("event", "callback, denied..")
            }
        }

        requestPermissionLauncher.launch("android.permission.ACCESS_FINE_LOCATION")

        val dateLog = DatePickerDialog(this, object: DatePickerDialog.OnDateSetListener{
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                Log.d("event", "year : $year, month: ${month+1}, day: $dayOfMonth")
            }
        }, 2024, 0, 1)

        dateLog.show()

        val timePickerDialog = TimePickerDialog(this, object: TimePickerDialog.OnTimeSetListener{
            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                Log.d("event", "time : $hourOfDay, minute : $minute")
            }
        }, 15, 0, true)

        timePickerDialog.show()

        val eventHandler = object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                if (which == DialogInterface.BUTTON_POSITIVE){
                    Log.d("event", "Positive Button click")
                } else if (which == DialogInterface.BUTTON_NEGATIVE){
                    Log.d("event", "Negative Button click")
                }
            }
        }

        AlertDialog.Builder(this).run {
            setTitle("text dialog")
            setIcon(android.R.drawable.ic_dialog_info)
            setMessage("정말로 종료하시겠습니까?")
            setPositiveButton("OK",eventHandler)
            setNegativeButton("Cancel", eventHandler)
            setNeutralButton("More", null)
            show()
        }

        val notification: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val ringtone = RingtoneManager.getRingtone(applicationContext, notification)
        ringtone.play()

        val vibrator = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            val vibratorManager = this.getSystemService(Context.VIBRATOR_MANAGER_SERVICE) as VibratorManager
            vibratorManager.defaultVibrator
        } else {
            getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        }

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val builder: NotificationCompat.Builder

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = "one-channel"
            val channelNAme = "My Channel One"
            val channel = NotificationChannel(
                channelId,
                channelNAme,
                NotificationManager.IMPORTANCE_HIGH
            )

            // 채널에 다양한 정보 설정
            channel.description = "채널 설명"
            channel.setShowBadge(true) // 홈화면에 확인하지 않은 알림 개수가 배지 아이콘에 표시
            val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val audioAttributes = AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_ALARM)
                .build()
            channel.setSound(uri, audioAttributes)
            channel.enableLights(true)
            channel.lightColor = Color.RED
            channel.enableVibration(true)
            channel.vibrationPattern = longArrayOf(100, 200, 100, 200)

            // 채널을 NotificationManager에 등록
            manager.createNotificationChannel(channel)

            // 채널로 빌더 생성
            builder = NotificationCompat.Builder(this, channelId)
        } else {
            builder = NotificationCompat.Builder(this)
        }

        // 정보 설정
        builder.setSmallIcon(android.R.drawable.ic_notification_overlay)
        builder.setWhen(System.currentTimeMillis())
        builder.setContentTitle("Content Title")
        builder.setContentText("Content Massage")
        // 알림 발생
        manager.notify(11, builder.build())

        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 10, intent, PendingIntent.FLAG_IMMUTABLE)
        builder.setContentIntent(pendingIntent)

        val KEY_TEXT_REPLY = "key_text_reply"
        var replyLabel: String = "답장"
        var remoteInput: RemoteInput = RemoteInput.Builder(KEY_TEXT_REPLY).run {
            setLabel(replyLabel)
            build()
        }

        builder.setProgress(100, 0, false)
        manager.notify(12, builder.build())
        thread {
            for (i in 1..100){
                builder.setProgress(100, i, false)
                manager.notify(12, builder.build())
                SystemClock.sleep(100)
            }
        }
         */
    }
}