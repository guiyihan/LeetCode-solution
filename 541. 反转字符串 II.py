class Solution:
    def reverseStr(self, string: str, k: int) -> str:
        time = len(string) // (2*k);
        s = list(string)
        for i in range(time):
            l=i*(2*k)
            r=l+k-1
            while l<r:
                s[l],s[r]=s[r],s[l]
                l+=1
                r-=1

        l=time*2*k
        r=min(len(s)-1,time*2*k + k-1)
        while l<r:
            s[l],s[r]=s[r],s[l]
            l+=1
            r-=1
        return ''.join(s)