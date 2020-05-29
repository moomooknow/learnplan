package com.example.learnplan.enumlearn;

/**
 * 枚举中添加方法
 * @author wangfk
 */
public enum ColorEnum {
    /**
     * red
     */
    RED("红色",1),
    /**
     * yellow
     */
    YELLOW("黄色",2);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private String name;
    private int index;
    ColorEnum(String name, int index){
        this.index = index;
        this.name = name;
    }
    public static String getNameByIndex(int index){
        for(ColorEnum colorEnum :
            ColorEnum.values()) {
            if(colorEnum.getIndex() == index) {
                return colorEnum.getName();
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getNameByIndex(1));
    }
}
