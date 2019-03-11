package testperson;

public class ShuiXianHua
{   public static void main(String[] args) 
    {   int i,j,k,n;
        
        for(n=100;n<1000;n++)
        {   i=n/100;
            j=n/10%10;          //j=(n-i*100)/10;   
            k=n%10;             //k=n-i*100-j*10;
           
           if(n==i*i*i+j*j*j+k*k*k)  
           {   System.out.println("水仙花: "+n);   }
        }
    }
}