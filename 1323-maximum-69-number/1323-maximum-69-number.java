class Solution {
    public int maximum69Number (int num) {
        String st=String.valueOf(num);
        StringBuilder sb=new StringBuilder();
        int c=0;
        for(int i=0;i<st.length();i++)
        {
            if(st.charAt(i)=='6' && c==0)
            {
                sb.append("9");
                c++;
            }

            else
            {
                sb.append(st.charAt(i));
            }

        }
        return Integer.parseInt(sb.toString());
    }
}