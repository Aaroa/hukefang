/*
 * Copyright (C) 2008 ZXing authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.zxing.android;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;

/**
 * The main settings activity.
 *
 * @author dswitkin@google.com (Daniel Switkin)
 * @author Sean Owen
 *
 * 配置类
 */
public final class PreferencesActivity extends Activity {

  public static final String KEY_DECODE_1D_PRODUCT = "preferences_decode_1D_product";//一维码 商品
  public static final String KEY_DECODE_1D_INDUSTRIAL = "preferences_decode_1D_industrial";//一维码 工业
  public static final String KEY_DECODE_QR = "preferences_decode_QR";//二维码


  public static final String KEY_PLAY_BEEP = "preferences_play_beep";//提示音
  public static final String KEY_VIBRATE = "preferences_vibrate";//振动
  public static final String KEY_COPY_TO_CLIPBOARD = "preferences_copy_to_clipboard";//复制到剪贴板

  public static final String KEY_FRONT_LIGHT_MODE = "preferences_front_light_mode";//是否开启闪光灯
  public static final String KEY_AUTO_FOCUS = "preferences_auto_focus";  //自动聚焦
  public static final String KEY_INVERT_SCAN = "preferences_invert_scan";  //反色
  public static final String KEY_BULK_MODE = "preferences_bulk_mode";//批量扫描模式

  public static final String KEY_CUSTOM_PRODUCT_SEARCH = "preferences_custom_product_search";//自定义搜索地址
  public static final String KEY_SEARCH_COUNTRY = "preferences_search_country";//搜索引擎国别

  public static final String KEY_DISABLE_CONTINUOUS_FOCUS = "preferences_disable_continuous_focus";//不持续对焦
  public static final String KEY_DISABLE_EXPOSURE = "preferences_disable_exposure";//不曝光

  @Override
  protected void onCreate(Bundle icicle) {
    super.onCreate(icicle);
    getFragmentManager().beginTransaction().replace(android.R.id.content, new Fragment()).commit();
  }


}
