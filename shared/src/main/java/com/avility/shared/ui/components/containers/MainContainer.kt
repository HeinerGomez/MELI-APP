package com.avility.shared.ui.components.containers

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.avility.shared.ui.constants.MeasureDimen
import com.avility.shared.ui.constants.white100

@Composable
fun MainContainer(
    isLoading: Boolean,
    header: (@Composable () -> Unit)? = null,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            header?.let {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(MeasureDimen.DIMEN_X50.value)
                        .background(MaterialTheme.colorScheme.surface)
                        .padding(MeasureDimen.DIMEN_X10.value),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    it()
                }
            }
            Spacer(Modifier.height(MeasureDimen.DIMEN_X04.value))
            Box(modifier = Modifier.padding(MeasureDimen.DIMEN_X10.value)) {
                content()
            }
        }
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .size(MeasureDimen.DIMEN_X26.value)
                    .align(Alignment.Center),
                trackColor = MaterialTheme.colorScheme.secondary,
            )
        }
    }
}