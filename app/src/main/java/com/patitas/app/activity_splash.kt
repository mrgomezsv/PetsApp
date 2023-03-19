package com.patitas.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class activity_splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide() //ocultar action bar
        setContentView(R.layout.activity_splash)

        val imageViewSplash : ImageView = findViewById(R.id.imageViewSplash)
        val fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        imageViewSplash.startAnimation(fadeInAnimation)

        // Listener para la animación
        fadeInAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation) {}

            override fun onAnimationEnd(animation: Animation) {
                // Iniciar LoginActivity después de que la animación termine
                val intent = Intent(this@activity_splash, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onAnimationRepeat(animation: Animation) {}
        })
    }
}
