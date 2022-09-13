package com.example.lesson1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
/*
    public void Sum(View view) {
        EditText tA= findViewById(R.id.var1);
        EditText tB= findViewById(R.id.var2);
        int a= Integer.parseInt(tA.getText().toString());
        int b= Integer.parseInt(tB.getText().toString());
        TextView tRes = findViewById(R.id.res1);
        tRes.setText(""+(a+b));
    }
*/
    public void Slay(View view){

        int n = 3;
        int m = 3;
        double[][] A = new double[100][100];
        double[] b = new double[100];
//todo разобраться с типами данных
        EditText tA1= findViewById(R.id.var1);
        double var1 = Double.parseDouble(tA1.getText().toString());;
        A[0][0] = var1;
        EditText tA2= findViewById(R.id.var2);
        double var2 = Double.parseDouble(tA2.getText().toString());
        A[0][1] = var2;
        EditText tA3= findViewById(R.id.var3);
        double var3 = Double.parseDouble(tA3.getText().toString());
        A[0][2] = var3;
        EditText tA4= findViewById(R.id.var4);
        double var4 = Double.parseDouble(tA4.getText().toString());
        b[0] = var4;



        EditText tA5= findViewById(R.id.var5);
        double var5 = Double.parseDouble(tA5.getText().toString());
        A[1][0] = var5;
        EditText tA6= findViewById(R.id.var6);
        double var6 = Double.parseDouble(tA6.getText().toString());
        A[1][1] = var6;
        EditText tA7= findViewById(R.id.var7);
        double var7 = Double.parseDouble(tA7.getText().toString());
        A[1][2] = var7;
        EditText tA8= findViewById(R.id.var8);
        double var8 = Double.parseDouble(tA8.getText().toString());
        b[1] = var8;




        EditText tA9= findViewById(R.id.var9);
        double var9 = Double.parseDouble(tA9.getText().toString());
        A[2][0] = var9;
        EditText tA10= findViewById(R.id.var10);
        double var10 = Double.parseDouble(tA10.getText().toString());
        A[2][1] = var10;
        EditText tA11= findViewById(R.id.var11);
        double var11 = Double.parseDouble(tA11.getText().toString());
        A[2][2] = var11;
        EditText tA12= findViewById(R.id.var12);
        double var12 = Double.parseDouble(tA12.getText().toString());
        b[2] = var12;

        /* Метод Гаусса */

        int N  = n;
        for (int p = 0; p < N; p++) {

            int max = p;
            for (int i = p + 1; i < N; i++) {
                if (Math.abs(A[i][p]) > Math.abs(A[max][p])) {
                    max = i;
                }
            }
            double[] temp = A[p]; A[p] = A[max]; A[max] = temp;
            double   t    = b[p]; b[p] = b[max]; b[max] = t;

            if (Math.abs(A[p][p]) <= 1e-10) {
                TextView TextRes = findViewById(R.id.TextRes);
                TextRes.setText("NO");
                return;
            }

            for (int i = p + 1; i < N; i++) {
                double alpha = A[i][p] / A[p][p];
                b[i] -= alpha * b[p];
                for (int j = p; j < N; j++) {
                    A[i][j] -= alpha * A[p][j];
                }
            }
        }

        // Обратный проход

        double[] x = new double[N];
        for (int i = N - 1; i >= 0; i--) {
            double sum = 0.0;
            for (int j = i + 1; j < N; j++) {
                sum += A[i][j] * x[j];
            }
            x[i] = (b[i] - sum) / A[i][i];
        }

        /* Вывод результатов */

        if (n < m) {
            TextView TextRes = findViewById(R.id.TextRes);
            TextRes.setText("INF");
        } else {
            TextView TextRes = findViewById(R.id.TextRes);
            TextRes.setText("YES");
            TextView Res = findViewById(R.id.res);
            Res.setText("" + x[0]);
            TextView Res1 = findViewById(R.id.res1);
            Res1.setText("" + x[1]);
            TextView Res2 = findViewById(R.id.res2);
            Res2.setText("" + x[2]);
        }
    }
}

