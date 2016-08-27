//
// Created by mike on 16-8-27.
//

#include "com_mikexapp_mikex_mikexapp_JNITest.h"

jint JNICALL Java_com_mikexapp_mikex_mikexapp_JNITest_add
  (JNIEnv *env, jobject clz, jint a, jint b){
    return (a + b);

  }