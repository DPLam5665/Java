import java.util.*;

import ToaDo.Point;

public class Main2 {
    public static void main(String [] args){
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Yellow");
        colors.add("Green");

        System.out.println(colors.get(1));

        colors.set(1, "Blue");

        colors.remove("Green");
        System.out.println(colors);

        colors.remove(1);
        System.out.println(colors);

        for (String color: colors){
            System.out.println(colors);
        }

        String [] colorArray = {"Red", "Black", "White"};

        ArrayList<String> colorList = new ArrayList<>(Arrays.asList(colorArray));

        Collections.sort(colorList);

        Collections.sort(colorList, (s1, s2) -> s1.compareTo(s2));
        System.out.println(colorList);

        System.out.println("##############################");
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(3,4));
        points.add(new Point(3,7));
        points.add(new Point(5,2));
        points.add(new Point(6,0));
        System.out.println("##############################");

        Comparator<Point> x_y_compare = new Comparator<Point>() {
            @Override
//            public int compare(Point o1, Point o2) {
//                return Integer.compare(o1.getX(), o2.getX());
//            }
//
//            public int compare(Point p1, Point p2) {
//                int temporary = Integer.compare(p1.getX(), p2.getX());
//                if(temporary == 0){
//                    return Integer.compare(p1.getY(), p2.getY());
//                }
//                return temporary;
//            }
            public int compare(Point p1, Point p2) {
                return Integer.compare(p1.getX() + p1.getY(), p2.getX()+p2.getY());
            }
        };
        Collections.sort(points, x_y_compare);
        for (Point p: points){
            System.out.println(p);
        }
        System.out.println("##############################");
    }
}
