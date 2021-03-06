package labas3;

import java.io.IOException;


public class Main 
{
    public static void main(String[] args) throws IOException 
    {    
        if(MatrixSize.Input_matrix() == 1)
        {
            MatrixSize.Input_matrix_from_key(5,5);
        }    
        else
        {
            MatrixSize.Input_matrix_from_file(5,5, "G:\\Курс 2\\Семестр 2\\Программирование\\ИСРПО\\Lab3\\in.txt");
        }
        
        MatrixSize.ArrayX_from_matrix(5);

        System.out.println("");
        
        MatrixSize.Print_matrix();

        System.out.println("");
        
        MatrixSize.Print_array();

        MatrixSize.Array_output("G:\\Курс 2\\Семестр 2\\Программирование\\ИСРПО\\Lab3\\out.txt");
    }
}
