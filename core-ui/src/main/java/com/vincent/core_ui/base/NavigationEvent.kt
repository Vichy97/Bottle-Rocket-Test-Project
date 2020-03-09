package com.vincent.core_ui.base

import android.os.Bundle
import androidx.annotation.IdRes

data class NavigationEvent(@IdRes val id: Int, val args: Bundle? = null)