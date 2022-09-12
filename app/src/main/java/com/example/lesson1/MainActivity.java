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

    public void Sum(View view) {
        EditText tA= findViewById(R.id.var1);
        EditText tB= findViewById(R.id.var2);
        int a= Integer.parseInt(tA.getText().toString());
        int b= Integer.parseInt(tB.getText().toString());
        TextView tRes = findViewById(R.id.res1);
        tRes.setText(""+(a+b));
    }

    public void Slay(View view){

        int n = 3;
        int m = 3;
        double[][] A = new double[100][100];
        double[] b = new double[100];
//todo разобраться с типами данных
        EditText tA1= findViewById(R.id.var1);
        int var1 = Double.parseInt(tA1.getText().toString());
        A[0][0] = var1.nextDouble();
        EditText tA2= findViewById(R.id.var2);
        int var2 = Integer.parseInt(tA2.getText().toString());
        A[0][1] = var2.nextDouble();
        EditText tA3= findViewById(R.id.var3);
        int var3 = Integer.parseInt(tA3.getText().toString());
        A[0][2] = var3.nextDouble();
        EditText tA4= findViewById(R.id.var4);
        int var4 = Integer.parseInt(tA4.getText().toString());
        b[0] = var4.nextDouble();



        EditText tA5= findViewById(R.id.var5);
        int var5 = Integer.parseInt(tA5.getText().toString());
        A[1][0] = var5.nextDouble();
        EditText tA6= findViewById(R.id.var6);
        int var6 = Integer.parseInt(tA6.getText().toString());
        A[1][1] = var6.nextDouble();
        EditText tA7= findViewById(R.id.var7);
        int var7 = Integer.parseInt(tA7.getText().toString());
        A[1][2] = var7.nextDouble();
        EditText tA8= findViewById(R.id.var8);
        int var8 = Integer.parseInt(tA8.getText().toString());
        b[1] = var8.nextDouble();

        EditText tA9= findViewById(R.id.var9);
        int var9 = Integer.parseInt(tA9.getText().toString());
        A[2][0] = var9.nextDouble();
        A[2][1] = s.nextDouble();
        A[2][2] = s.nextDouble();

        b[i] = s.nextDouble();


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
                System.out.println("NO");
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
            System.out.print("INF");
        } else {
            System.out.println("YES");
            for (int i = 0; i < N; i++) {
                System.out.print(x[i] + " ");
            }
        }
    }
}

