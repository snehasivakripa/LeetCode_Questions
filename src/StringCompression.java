public class StringCompression {

    public int compress(char[] chars) {
        int index=0;
        int count=1;
        if(chars.length==1){
            chars[index++]=chars[0];
        }
        for(int i=1;i<chars.length;i++){
            if(chars[i]==chars[i-1]){
                count++;
            }else if (Character.isDigit(chars[i-1])) {
                count++;
            }else{
                chars[index++]=chars[i-1];
                if(count>1) {
                    for(char n:Integer.toString(count).toCharArray())
                    {
                       chars[index++]=n;
                    }
                }
                count=1;
            }
            if(i==chars.length-1){
                chars[index++]=chars[i-1];
                for(char n:Integer.toString(count).toCharArray())
                {
                    chars[index++]=n;
                }
            }
        }
        return index;
    }

    public static void main(String[] args) {
        char[] ch={'a','a','b','b','c','c','c'};
        StringCompression str=new StringCompression();
        System.out.println(str.compress(ch));
    }
}
