
class Solution {
public:
    int lengthOfLastWord(string s) {
        s.erase(0, s.find_first_not_of(' '));
        s.erase(s.find_last_not_of(' ') + 1);
        int count =0;
        for(int i=s.size()-1 ; i>=0; i--) {
            if(s[i] == ' ') {
               break;
            }
            count++;
            
        }
        return count;
    }
};