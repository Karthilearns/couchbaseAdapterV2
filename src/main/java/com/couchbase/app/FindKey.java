package com.couchbase.app;

public class FindKey
{
    public String find(String word)
    {
        String res ="";
        BB:
        for(int i=0;i<word.length();i++)
        {
            if(word.charAt(i)=='"')
            {

                for(int j = i+1;j<word.length();j++)
                {
                    if(word.charAt(j)=='"')
                    {
                        break BB;
                    }
                    res+=""+word.charAt(j);
                }
            }
        }
        System.out.println(res);
        return res;
    }

}
