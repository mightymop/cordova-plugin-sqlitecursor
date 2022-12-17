package de.mopsdom.sqlitecursor;

import android.database.CursorWindow;
import android.os.Build;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;


public class sqlitecursor extends CordovaPlugin {

  private void setSize(final JSONArray data, final CallbackContext callbackContext) {

    if (data == null || data.length() == 0) {
      callbackContext.error("bad request (parameter)");
      return;
    }


    try {
      JSONObject obj = data.optJSONObject(0);

      if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
        Field field = CursorWindow.class.getDeclaredField("sCursorWindowSize");
        field.setAccessible(true);
        field.set(null, 100 * 1024 * 1024);
      }
    } catch (Exception e) {
      Log.e("cordova-plugin-sqlitecursor", e.getMessage());
    }
    callbackContext.success();
  }

  @Override
  public boolean execute(final String action, final JSONArray data, final CallbackContext callbackContext) {

    if (action.equals("setSize")) {

      cordova.getThreadPool().execute(new Runnable() {
        public void run() {
          setSize(data, callbackContext);
        }
      });

      return true;
    }

    return false;
  }
}
