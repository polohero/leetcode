public class Solution {
    public IList<string> TopKFrequent(string[] words, int k) {
        
        Dictionary<string, WordCount> wordCountDictionary = 
            findWordCount(words);
        
        List<WordCount> wordCount = new List<WordCount>(wordCountDictionary.Values);
        
        wordCount.Sort(sortWordCount);
        
        if( wordCount.Count <= k )
        {
            return getReturnValue(wordCount);
        }    
        else
        {
            return getReturnValue(wordCount.GetRange(0, k));   
        }
    }
    
    private IList<string> getReturnValue(List<WordCount> wordCounts){
        
        IList<string> strings = new List<string>(wordCounts.Count);
        
        foreach(WordCount word in wordCounts){
            strings.Add(word.Word);
        }
        
        return strings;
    }
    
    private int sortWordCount(WordCount one, WordCount two)
    {
        int result =  two.Count.CompareTo(one.Count);
        
        if( result == 0)
        {
            result = one.Word.CompareTo(two.Word);
        }
        
        return result;
    }
    
    private Dictionary<string, WordCount> findWordCount(string[] words)
    {
        Dictionary<string, WordCount> wordCountDictionary = 
            new Dictionary<string, WordCount>(words.Length);
        
        foreach(string word in words)
        {
            WordCount wordCount = null;
            
            if( wordCountDictionary.TryGetValue(word, out wordCount))
            {
                wordCount.Count = wordCount.Count += 1;
            }
            else
            {
                wordCount = new WordCount(word);
                wordCountDictionary.Add(word, wordCount);
            }
            
        }
        
        return wordCountDictionary;
    }
}

public class WordCount
{
    
    public WordCount(string word){
        Word = word;
        Count = 1;
    }
    
    
    public string Word{get;set;}
    public int Count{get;set;}
}

                    
