package labas3;

import java.util.Scanner;
import java.io.*;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MatrixSize 
{
    private static Scanner in = new Scanner(System.in);
    private static int line;
    private static int column;
    private static int how;
    private static int[][] matrix;
    private static int[] arrayx;

    public static int Input_matrix()
    {
        System.out.println("Вводить матрицу с клавиатуры (введите 1) или импортировать из файла (введите 2)?");
        how = in.nextInt();
        return how;
    }
    
    public static void Input_matrix_from_key(int line1, int column1)
    {
        System.out.println("Введите элементы матрицы: ");
        line = line1;
        column = column1;
        matrix = new int[line][column];
        for (int i = 0; i < line; i++)
        {
            for(int j = 0; j < column; j++)
            {
                matrix[i][j] = in.nextInt();
            }    
        }    
    }
    
    public static void Input_matrix_from_file(int line1, int column1, String str) throws IOException {
        line = line1;
        column = column1;
        Path path = Paths.get(str);
        try (Scanner fin = new Scanner(path)) 
        {
            fin.useDelimiter(" ");
            matrix = new int[line][column];
            for (int i = 0; i < line; i++)
            {
                for(int j = 0; j < column; j++)
                {
                    matrix[i][j] = fin.nextInt();
                }    
            }                   
        }
        
        catch (FileNotFoundException e) 
        {
            System.out.println("Ошибка " + e + "! файл " + str + " не найден!");
        }
    }
    
    //Начало варианта
    
    
    
    public static void Print_matrix()
    {
        System.out.println("Матрица:");
        
        for (int i = 0; i < line; i++)
        {
            for(int j = 0; j < column; j++)
            {    
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    
    public static void ArrayX_from_matrix(int size) 
    { 
        arrayx = new int[size];
        
        
        for (int i = 0; i < line; i++) 
        {
            
            if(matrix[i][i] > matrix[i][size - 1 - i])
            {
                arrayx[i] = 1;
            }
            else
            {    
                arrayx[i] = -1;
            }    
        }
    }
    
    public static void Print_array()
    {
        System.out.println("Массив Х:");
        
        System.out.print("X = {");
        
        for (int i = 0; i < arrayx.length; i++)
        {
            System.out.print(arrayx[i] + " ");
        }  
        
        System.out.print("}");
    }
    
    public static void Array_output(String path) throws FileNotFoundException 
    {
        String str = "";
        
        for (int i = 0; i < arrayx.length; i++)
        {    
            str += arrayx[i] + " ";
        }
        
        PrintWriter pw = new PrintWriter(new File(path));
        pw.println(str);
        pw.close();
    }
}
