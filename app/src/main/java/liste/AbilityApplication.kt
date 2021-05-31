package liste

import android.app.Application
import android.content.Context

class AbilityApplication : Application() {
    companion object{
        var context: Context? = null
    }
   override fun onCreate() {
    super.onCreate()
    context = this
}
}