package 剑指Offer;

public class O62_yuan_quan_zhong_zui_hou_sheng_xia_de_shu_zi_lcof {
    public int lastRemaining(int n, int m) {
        //链表的约瑟夫环问题,主要是id映射, 旧=(新+m)%n  id从0开始算
        int dp = 0;
        for (int i = 2; i <= n; i++) {
            dp = (dp + m) % i;
        }
        return dp;
    }

    public static void main(String[] args) {
        int n = 10, m = 17;
        O62_yuan_quan_zhong_zui_hou_sheng_xia_de_shu_zi_lcof s = new O62_yuan_quan_zhong_zui_hou_sheng_xia_de_shu_zi_lcof();
        int i = s.lastRemaining(n, m);
        System.out.println(i);
    }
}
