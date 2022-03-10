import java.math.MathContext;
import java.util.Arrays;

public class Main {
    //one
 static int centered(int[] arr){
     int midIndex=(int) Math.floor(arr.length/2);
     int middleVal=arr[midIndex];
     Boolean isValid=true;
     if (arr.length%2==0 ||arr.length==0) return 0;
     for( int i=0; i<arr.length;i++){
         if(i==midIndex) continue;
         if(arr[i]<=middleVal) isValid=false;
     }
     return isValid? 1:0;
 }
 //two
 static int f(int[ ] a){
     int even=0;
     int odd=0;
     for( int i=0;i<a.length;i++){
         if(a[i]%2==0) even+=a[i];
         else odd+=a[i];
     }
     return odd-even;
 }
 //three
 static char[ ] f3(char[ ] a, int start, int len){
     int alen=a.length;
     if(len>alen-start || start<0 ||len<0) return null;
     char[] na=new char[len];
     for(int i=0;i<len;i++){
           na[i]=a[start+i];
     }
     return na;
 }
 //four
 static int f4(int n){ /* reverse the integer.*/
     String str=Integer.toString(n);
     String tot="";
     if(n<0) str=str.substring(1);//
     for(int i=str.length()-1;i>=0;i--){
         tot+= str.charAt(i) ;
     }
     if(n<0) tot="-"+tot;
     n=Integer.parseInt(tot);//
     return n;
 }
 //five
 static int[] f5(int[] first, int[] second){
     if(first ==null || second==null) return null;
     else if(first.length==0 || second.length==0) return new int[] {};
     else {
         int [] shrt;int[] lng;int[] temp;
         if(first.length>second.length){
             shrt=second;
             lng=first;
         }else{
             shrt=first;
             lng=second;
         }//end;
         temp=new int[shrt.length];int mismatch=0;
         for(int i=0;i<shrt.length;i++){
             for(int j=0;j<lng.length;j++){
                 if(shrt[i]==lng[j]) {
                     temp[i]=shrt[i];
                 }else mismatch++;
             }
         }
         int [] retunVal=new int[temp.length-mismatch];
         int jmp=0;
         for( int i=0;i<temp.length;i++){
             if(temp[i]!=0){
                 retunVal[temp.length-i-jmp-mismatch]=temp[i];
             }else{
                 jmp++;
             }
         }
         /*
         * {0,1,0,0,0,12},
         *
         *
         * */
         //System.out.println(Arrays.toString(temp)+temp.length);
         return temp;
         }
     }
 //six:not finished
 static int f7(int[] a){
     //point of equilibrium
     int [] lt;int [] rt;int pos=-1;//left and right sub array from the point of equilibrium.
     if(a==null||a.length==0) return pos;
     for(int i=0;i<a.length;i++){
         if(i==0) continue;
         else{
             lt=Arrays.copyOfRange(a,0,i);
             rt=Arrays.copyOfRange(a, i+1,a.length);
             int sumlt=0;int sumrt=0;
             for(int elem:lt ){
                 sumlt+=elem;
             }
             for(int elem:rt){
                 sumrt+=elem;
             }
             if(sumlt==sumrt) {
                 pos=i;
                 break;
             }
         }
     }
     return pos;
 }
//seven
 static int primeCount(int start, int end){
     if(start>end) return 0;
     int count=0;
     for( int i=start;i<=end;i++){
         if(i%2==0 &&i!=2) continue;
         int isPrimeCount=0;
         for(int j=1;j<=i;j++){
             if(j%2==0 &&j!=2) continue;
             if( (double)  i/j==Math.floor(i/j)) isPrimeCount++;
         }
         if(isPrimeCount==2) count++;
     }
 return count;
 }
static int isMadhavArray(int[ ] a){
     int curr; int prev;
//1,2,3,4,5,6: n(n+1)
    if(a.length==1||a.length==0) return 0;
    int span=1;
    for(int i=0;i<a.length;i++){
        for(int j=i;j<span+j;j++){

        }
        span++;
    }
     return 0;
    //0 1 3 6 10
}
static int isInertial(int [] a){
    int[] odd;int [] even;int oddl=0;int evenl=0;
    int max=a[0];
    if(a[0]%2==0)evenl++;
    else oddl++;
    for(int i=1;i<a.length;i++){
        if(a[i]%2==0) evenl++;
        else oddl++;
        if(max<a[i])max=a[i];//finds max
    }
    if(max%2!=0) return 0;//max is not even.
    else evenl=evenl-1;//max is even and reduce even array,"even", length by one.
    odd=new int[oddl];
    even=new int[evenl];
    int oddi=0;int eveni=0;//index
    boolean isValid = true;
    for (int i = 0; i < a.length; i++) {
            if (a[i] % 2 == 0 && a[i] != max){
                even[eveni] = a[i];
                eveni++;
            } else if(a[i] % 2 != 0) {
                odd[oddi] = a[i];
                oddi++;
            }
        }
    if(odd.length==0) return 0;//no odd value.
    for (int i = 0; i < odd.length; i++) {
            for (int j = 0; j < even.length; j++) {
                if (odd[i] < even[j]) isValid = false;
            }
    }

   if(isValid) return 1;
   return 0;
}
static int countSquarePairs(int[ ] a){
     if(a.length<2) return 0;
     int pair=0;double sqr;
     for(int i=0;i<a.length;i++){
         //forward check up
         for(int f=1+i;f<a.length;f++){
             if(a[f]>a[i]&&a[f]>0&&a[i]>0){
                 sqr= Math.sqrt(a[f]+a[i]);
                 if( sqr==Math.floor(sqr)) {
                     pair++;
                 }
             }
         }
         //backward check up
         for(int b=0;b<i;b++){
             if(a[b]>a[i]&&a[b]>0&&a[i]>0){
                 sqr= Math.sqrt(a[b]+a[i]);
                 if( sqr==Math.floor(sqr)) {
                     pair++;
                 }
             }
         }
     }
     return pair;
}
static int findPorcupineNumber(int n){
      class Prime{
         static boolean isPrime(int n){
             int factors=0;
             for( int i=1;i<=n;i++){
                 if(i!=2&&n%2==0) continue;//evens except two are not prime , so jump.
                 if((double)n/i==Math.floor(n/i)) factors++;
             }
             if(factors==2) return true;//a prime num has 2 factors.
             return false;
         }
     }
     int lstDigit=n%10;
     if(Prime.isPrime(n) && lstDigit==9){
       int porcup;
       while(true){
            porcup=++n;
            lstDigit=porcup%10;
           if(Prime.isPrime(porcup) && lstDigit==9) return porcup;
       }
     }
     return -1;


}
static int isGuthrieSequence(int[ ] a){
     int init=a[0]; // {8, 4, 1, 1}
     int ret=0;
     for(int i=0;i<a.length;i++){
        if(init==a[i]){
             if(init==1){
              ret= 1;
              break;
             }
            if(init%2==0) {
                init = init / 2;
            }
            else init=init*3+1;
         }else break;
     }
     return ret;
}
static int stantonMeasure(int[ ] a) {
        int oneOccur = 0;
        int tot = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 1) {
                oneOccur++;
            }
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == oneOccur) {
                tot++;
            }
        }
        return tot;
 }
static int sumFactor(int[ ] a){
     if(a.length==0) return 0;
     int sum=0;int appear=0;
     for(int i=0;i<a.length;i++){
         sum+=a[i];
     }
     for(int i=0;i<a.length;i++){
        if(sum==a[i]) appear++;
     }
     return appear;
}




 public static void main(String[] args){

   System.out.print("Result: "+ sumFactor(new int[] {0, 0, 0})) ;

 }
}
 
