package HashMapTest;
import java.util.*;
import java.util.stream.Collectors;

public class Hashmap1 {
    public static void test1(){
        HashMap<String, String> map = new HashMap<>();
        map.put("USA", "Washington, DC");
        map.put("France", "Paris");
        map.put("Japan", "Tokyo");

//      Kiem tra su ton tai cua mot khoa
        if(map.containsKey("France")){
            System.out.println("Thu do cua nuoc Phap la: " + map.get("France"));
        }

//      Kiem tra su ton tai cua mot gia tri
        if(map.containsValue("Tokyo")){
            System.out.println("Tokyo co ton tai trong map");
        }

//      Xoa mot phan tu
        map.remove("japan");
        System.out.println("###########################");

//      In ra cac phan tu con lai cua Hashmap
        for(String key: map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }

        System.out.println("###########################");
//      Lap qua cac cap gia tri bang cach su dung entrySet()
        for(Map.Entry<String, String>entry : map.entrySet()){
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Country: " + key + ", capital: " + value);
        }

        System.out.println("###########################");
//      Lay gia tri voi khoa co san
        System.out.println("Gia tri cua khoa 'USA': " + map.getOrDefault("USA", "Key not found" ));

//      Lay gia tri voi khoa khong co san
        System.out.println("Gia tri cua khoa 'C': " + map.getOrDefault("C", "Key not found" ));

//      Them hoac cap nhat gia tri neu khoa khong co mat (thya doi kieu gia tri thanh String)
        map.putIfAbsent("Vietnam", "Hanoi");
        System.out.println("Gia tri cua Viet Nam: " + map.get("Vietnam"));

//      Cap nhat gia tri neu khoa co mat (Thay doi kieu gia tri tu Paris => Paris(Updated))
        map.computeIfPresent("France", (k,v) -> v + " (Updated)");
        System.out.println("Update thu do cua Phap: " + map.get("France"));
    }

    public static void test2(){
        String s="xin chao chao xin pho phuong bao phuong pho";
        HashMap<String, Integer> map = new HashMap<>();
        String[] words = s.split("");
        for(String x : words){
            int count = map.getOrDefault(x, 0);
            map.put(x, count + 1);
        }

        for(String key : map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }
    }

    public static void test3(){
        String s="xin chao chao xin pho phuong bao phuong pho";
        HashMap<String, Integer> map = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(s);
        while(tokenizer.hasMoreTokens()){
            String word = tokenizer.nextToken();
            map.put(word,map.getOrDefault(word, 0)+1);
        }

        for(String key : map.keySet()){
            System.out.println(key + ": " + map.get(key));
        }
    }

    public static void test4(){
//      Tao mot hashmap de luu tru tu dien
        HashMap<String, String> dictionary = new HashMap<>();

//      Them mot so tu va dinh nghia vao tu dien
        dictionary.put("Apple", "A type of fruit that is typically round and has red, green or yellow color");
        dictionary.put("Banana", "Long, curved fruit with yellow skin and soft, sweet and white flesh");
        dictionary.put("Cherry", "A small, round fruit that is typically red or black");

        Scanner sc = new Scanner(System.in);
        System.out.println("Moi ban nhap tu vung can tra cuu: ");
        String name = sc.nextLine();
        String res = dictionary.get(name);
        if (res != null){
            System.out.println(name + ": " + res);
        }else{
            System.out.println("Tu ban vua nhap khong co trong du lieu cua tu dien!!!!");
        }

    }
    public static void test5(){
        HashMap<String, Integer> cty = new HashMap<>();

//      Quoc gia co so cong ty co von tren 10 trieu do
        cty.put("Vietnam", 25);
        cty.put("Japan", 6);
        cty.put("USA", 2);
        cty.put("France", 11);

        System.out.println("###########################");
//      In ra man hinh cac phan tu con lai trong hashmap
        for (String key: cty.keySet()){
            System.out.println(key + ": " + cty.get(key) );
        }

        System.out.println("###########################");
//      In ra man hinh cac phan tu con lai trong hashmap
        cty.entrySet().stream()
                .forEach(item -> System.out.println(item.getKey() + ": " + item.getValue()));

        System.out.println("###########################");
//      Tinh tong luong cac cong ty tren
        int kq = cty.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Tong tat ca cong ty la: " + kq);

        System.out.println("###########################");
//      Loc cac quoc gia co so luong cty > 5
        Map <String, Integer> newMap = cty.entrySet().stream()
                .filter(item -> item.getValue()>5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(newMap);

        System.out.println("###########################");
//      Sap xep giam dan theo so luong cong ty
        cty.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(item -> System.out.println(item.getKey() + ": " + item.getValue()));
        System.out.println(newMap);
        System.out.println("########################### map 1");
//      Loc cac quoc gia co so luong cong ty > 7
//      Loc cac phan tu co gia tri > 7 va thu thap vao mot hashmap moi
        Map<String, Integer> newMap1 = cty.entrySet().stream()
                .filter(entry -> entry.getValue() > 5)
                .collect(Collectors.toMap(
                        entry -> entry.getKey(),
                        entry -> entry.getValue()
                ));
        System.out.println(newMap1);
    }
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
    }



}
