class WordsFrequency {
	/*
	使用java8中的 stream
	*/
    Map<String,Long> dict=new HashMap();

    public WordsFrequency(String[] book) {
        Stream<String> stream = Stream.of(book).parallel();
        dict = stream.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
    }
    
    public int get(String word) {
        if(dict.containsKey(word)){
            return dict.get(word).intValue();
        }else{
            return 0;
        }
    }
}