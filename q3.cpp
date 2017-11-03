//3. Longest Substring Without Repeating Characters
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> map;
        int longest = 0;
        int start_ind = 0;
        int size = 0;
        for(int i = 0; i < s.size();i ++){
            if(map.find(s.at(i)) == map.end()){
                map[s.at(i)] = i;
                size ++;
            }
            else{
                int ind = map[s.at(i)];
                size = size - (ind - start_ind);
                map[s.at(i)] = i;
                for(int k = start_ind;k < ind;k ++)
                    map.erase(s.at(k));
                start_ind = ind + 1;
            }
            if(size > longest)
                longest = size;
        }
        return longest;
    }
};