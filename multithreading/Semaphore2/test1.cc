#include<iostream>

using namespace std;

int Max_3(int i, int j, int k)
{
    int max = i > j ? i : j;
    max = max > k ? max : k;
    return max;  
}

int MaxScore(int arr[], int low, int high, int counter,int *first, int *second)
{
    if(counter%2 == 1 && first[low] != -1)
    {

	cout << "returning : " << low <<": first[low] : " << first[low] <<endl;
        return first[low];
    }
    
    if(counter%2 == 0 && second[low] != -1)
    {

	cout << "returning : " << low <<": second[low] : " << second[low] <<endl;
        return second[low];
    }
    
   if((high - low + 1) <= 3)
   {
       int s = 0;
       for(int i = low; i <= high; i++)
       {
           s = s + arr[i];
       }
	cout << "player " <<counter%2 << " : low : "<<low<< ",s:" <<s<<endl;       
       if(counter%2 == 1)
       {
           first[low] = s;
       }
       else
       {
           second[low] = s;
       }
       return s;
   }
    
    
   int s = 0;
    
   for(int i = low; i <= high; i++)
   {
       s = s + arr[i];
   }
   
   cout <<"Starting Player : " << counter%2 << endl; 
   int i = s - MaxScore(arr,low+1,high,counter+1,first,second);//what was my part from low+1 onwwardds
   int j = s - MaxScore(arr,low+2,high,counter+1,first,second);
   int k = s - MaxScore(arr,low+3,high,counter+1,first,second);
    
   cout << "low : " << low << endl;
   cout << "i: " << i << ",j: " << j << ",k: " <<k << endl; 
   if(counter%2 == 1)
   {
       first[low] = Max_3(i,j,k);
   }
   else
   {
       second[low] = Max_3(i,j,k);
   }
    
   return Max_3(i,j,k);
}
int main()
{
    int T;
    cin>>T;
    
    while(T-- > 0)
    {
        int N;
        cin>>N;
        
        int* arr = new int[N];
        
        for(int i = 0; i < N; i++)
        {
            cin>>arr[i];
        }
       
        int *first = new int[N];
        int *second = new int[N];
        
        for(int i = 0; i < N;i++)
        {
            first[i] = -1;
            second[i] = -1;
        }
        
        int max = MaxScore(arr,0,N-1,1,first,second);
      
        cout<<max<<endl;
    }
    return 0;
}
