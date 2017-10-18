/*
 * Android-PercentProgressBar
 * Copyright (c) 2015  Natasa Misic
 *
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package com.natasa.progresspercent;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

import com.natasa.progresspercent.lib.CircularProgress;
import com.natasa.progresspercent.lib.LineProgress;
import com.natasa.progresspercent.lib.OnProgressTrackListener;

public class MainActivity extends AppCompatActivity {

    private CircularProgress circularProgress;
    private LineProgress lineProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);
        circularProgress = (CircularProgress) findViewById(R.id.circular);
        lineProgress = (LineProgress) findViewById(R.id.line);


        lineProgress.setRoundEdge(true);
        lineProgress.setShadow(true);
        lineProgress.setTypeface("Roboto-Regular.ttf");
        lineProgress.setBackgroundColor(Color.LTGRAY);
        lineProgress.setProgressColor(Color.GREEN);
        lineProgress.setTextColor(Color.BLACK);

        circularProgress.setTypeface("Roboto-Regular.ttf");
        circularProgress.setTextSize(30);
        circularProgress.setBackgroundStrokeWidth(10);
        circularProgress.setProgressStrokeWidth(15);
        circularProgress.setRoundEdge(true);
        circularProgress.setShadow(true);
        circularProgress.setOnProgressTrackListener(new OnProgressTrackListener() {
            @Override
            public void onProgressFinish() {
                Toast.makeText(MainActivity.this, "进度等于100", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onProgressUpdate(int progress) {
            }
        });
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                circularProgress.setProgress(progress);
                lineProgress.setProgress(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
}
