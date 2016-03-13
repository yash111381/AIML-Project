/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author Yash
 */
import java.util.*;
class dmin
{    int m=0,n=3;
            public int cal(int temp[][],int t[][])
             {
         m=0;
                        for(int i=0;i<n;i++)
                           for(int j=0;j<n;j++)
                             {
                                    if(temp[i][j]!=t[i][j])
                                       m++;
                             }
                         return m;
             }
             
             public boolean check(int a[][],int t[][])
             {
                        boolean f=true;
                                    for(int i=0;i<n;i++)
                                 for(int j=0;j<n;j++)
                                    if(a[i][j]!=t[i][j])
                                            f=false;
                        return f;
             }
           
}



public class JavaApplication1
{
            public static void main(String ag[])
              {
                        Scanner s=new Scanner(System.in);
                        System.out.println("enter the matrix to be solved,space with zero");
                        int n=3;
                        int a[][]=new int[n][n];
                        int t[][]=new int[n][n];
                        for(int i=0;i<n;i++)
                           for(int j=0;j<n;j++)
                               a[i][j]=s.nextInt();
                         System.out.println("enter the target matrix,space with zero");
                                    for(int i=0;i<n;i++)
                           for(int j=0;j<n;j++)
                               t[i][j]=s.nextInt();
                               
                          int m=0,x=0,y=0,d=10000,dmin=0,l=0;
                          dmin g=new dmin();
                          int temp[][]=new int[n][n];
                          int r[][]=new int[n][n]; 
                                System.out.println();
                                System.out.println("The solution is as follows\n");
                                
               while(!(g.check(a,t)))
                          { l++;d=10000;
                           
                                     for(int i=0;i<n;i++)
                                        for(int j=0;j<n;j++)
                                           {
                                                 if(a[i][j]==0)
                                                    {x=i;y=j; }
                                           }
                             
                                      //up
                                                for(int i=0;i<n;i++)
                                     for(int j=0;j<n;j++)
                                          temp[i][j]=a[i][j];
                                          
                                         
                                       if(x!=0)
                                          {
                                                int p=temp[x][y];
                                                temp[x][y]=temp[x-1][y];
                                                temp[x-1][y]=p;
                                          }    
                                         m=g.cal(temp,t);
                                         dmin=l+m; 
                                        if(dmin<d)
                                         { d=dmin;
                                                for(int i=0;i<n;i++)
                                     for(int j=0;j<n;j++)
                                          r[i][j]=temp[i][j];
                                         }
                                          
                                      //down
                                      for(int i=0;i<n;i++)
                                     for(int j=0;j<n;j++)
                                          temp[i][j]=a[i][j];
                                       if(x!=n-1)
                                        {
                                                int p=temp[x][y];
                                                temp[x][y]=temp[x+1][y];
                                                temp[x+1][y]=p;
                                          }    
                                         m=g.cal(temp,t);
                                         dmin=l+m; 
                                        if(dmin<d)
                                          { d=dmin;
                                                for(int i=0;i<n;i++)
                                     for(int j=0;j<n;j++)
                                          r[i][j]=temp[i][j];
                                         }
                                          
                                         //right
                                           for(int i=0;i<n;i++)
                                     for(int j=0;j<n;j++)
                                          temp[i][j]=a[i][j];
                                       if(y!=n-1)
                                        {
                                                int p=temp[x][y];
                                                temp[x][y]=temp[x][y+1];
                                                temp[x][y+1]=p;
                                          }    
                                         m=g.cal(temp,t);
                                         dmin=l+m; 
                                        if(dmin<d)
                                          { d=dmin;
                                                for(int i=0;i<n;i++)
                                     for(int j=0;j<n;j++)
                                          r[i][j]=temp[i][j];
                                         } 
                                          
                                          //left
                                                for(int i=0;i<n;i++)
                                     for(int j=0;j<n;j++)
                                          temp[i][j]=a[i][j];
                                       if(y!=0)
                                          {
                                                int p=temp[x][y];
                                                temp[x][y]=temp[x][y-1];
                                                temp[x][y-1]=p;
                                          }    
                                         m=g.cal(temp,t);
                                         dmin=l+m;  
                                        if(dmin<d)
                                          { d=dmin;
                                                for(int i=0;i<n;i++)
                                     for(int j=0;j<n;j++)
                                          r[i][j]=temp[i][j];
                                         } 
                                           
                                       for(int i=0;i<n;i++)
                                         {for(int j=0;j<n;j++)
                                               System.out.print(r[i][j]+" ");
                                            System.out.println();               
                                          }
                                                for(int i=0;i<n;i++)
                                     for(int j=0;j<n;j++)
                                         { a[i][j]=r[i][j];
                                           temp[i][j]=0;
                                         }
                                                System.out.println();    
                                     
                                              //  System.out.println(d);    
                                     }
              }
}