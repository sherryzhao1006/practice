import java.io.*;
public class Main {
    public static void main (String[] args) throws IOException {
        File file = new File(args[0]);
        BufferedReader buffer = new BufferedReader(new FileReader(file));
        String line;
        while ((line = buffer.readLine()) != null) {
            line = line.trim();
            String[] strArray = line.split(" ");
            int[] intArray = new int[strArray.length];
            for (int i = 0; i < strArray.length;i++){
                intArray[i] = Integer.parseInt(strArray[i]);
            }
            int max =0;
            int st = 0;
            for (int i=0; i < intArray.length-1;i++){
                for(int j=i+1; j < intArray.length;j++) {
                    int c = 0;
                    while(i+c < j && j+c < intArray.length && intArray[i+c] == intArray[j+c]){
                        c++;
			System.out.println("i : " + (i+c) + ",j: " + (j+c) + ",c : " + c);
		    }
                    if(c > max){
                        max = c;
                        st = i;
                    }
                }
            }
            while(max > 0){
                    System.out.print(intArray[st++]);
                if(max !=1)                
                    System.out.print(" ");
                max--;
            }
            System.out.println();
        }
    }
}

