package first;

public class CesarShift {

    int offset=3;
    public String encrypt(String s)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0; i < s.length(); i++)
        {
            char t=s.charAt(i);
            if(t>='A' && t<='Z') {
                int t1=t-'A'+offset;
                t1=t1%26;
                sb.append((char)(t1+'A'));
            } else if(t>='a' && t<='z') {
                int t1=t-'a'+offset;
                t1=t1%26;
                sb.append((char)(t1+'a'));
            } else {
                sb.append(t);
            }
        }
        return sb.toString();
    }

    public String decrypt(String s)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++) {
            char t=s.charAt(i);
            if(t>='A' && t<='Z') {
                int t1=t-'A'-offset;
                if(t1<0)t1=26+t1;
                sb.append((char)(t1+'A'));
            } else if(t>='a' && t<='z') {
                int t1=t-'a'-offset;
                if(t1<0)t1=26+t1;
                sb.append((char)(t1+'a'));
            } else {
                sb.append(t);
            }
        }
        return sb.toString();
    }

}
