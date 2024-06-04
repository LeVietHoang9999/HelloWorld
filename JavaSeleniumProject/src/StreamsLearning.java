import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamsLearning {
	//@Test
	public void streamFilter() {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Aronadol");
		names.add("Schannel");
		names.add("FireFoxQueen");
		names.add("Amessi");
		names.add("aBaseball");
		Long c= names.stream().filter(a->a.startsWith("A")).count();
		System.out.println(c);
	}
	
	public void streamMap() {
		//dua vao 1 danh sach ten -> lay ra cac ten startwith A -> Make them uppercase -> sort them in order-> print them out. 
		List<String> names = new ArrayList<String>();
		names.add("Tokyo");
		names.add("Fukuoka");
		names.add("Saitama");
		names.add("Akaido");
		
		
		List<String> names1 = Arrays.asList("Aronadol","Schannel","FireFoxQueen","Amessi","aBaseball","Ahanni");
		//Stream.of("Aronadol","Schannel","FireFoxQueen","Amessi","aBaseball","Ahanni").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		//names1.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		//newStream.filter(s->s.startsWith("A")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s->s.equalsIgnoreCase("Schannel"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	@Test 
	public void streamCollect() {
		//tao ra 1 stream dc sort, uppercase, filter -> chuyen stream thanh 1 list string-> get phan tu 0 ra man hinhf testNG
//		List<String> ls = Stream.of("Aronadol","Schannel","FireFoxQueen","Amessi","aBaseball","Ahanni").filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).collect(Collectors.toList());
//		for(int i =0;i<ls.size();i++) {
//			System.out.println(ls.get(i));
//		}
		List<Integer> lsi = Arrays.asList(7,6,6,2,2,8,1,2,3,5,9,8,9);
		//List<String> ls1 = new ArrayList<String>();
		List<Integer> lsi_new = lsi.stream().distinct().sorted().collect(Collectors.toList());//List -> Stream de su dung functions -> ve List. 
		//get the 3rd item in the ls1 by using Stream power: 
		System.out.println(lsi_new.get(2));
		System.out.println("-----------");
		lsi.stream().distinct().sorted().forEach(s->System.out.println(s));
		
	}
	 

}
