public class MergeTest{
    public static void main(String[] args){
        int[] list1 = {2, 5, 9, 11, 17, 21, 22, 60};
        int[] list2 = {1, 3, 8, 12, 15, 19, 23, 59};
        int[] result = merge(list1, list2);
        for(int i = 0; i < result.length; i++){
            System.out.printf("%5d", result[i]);
        }
    }
    public static int[] merge(int[] list1, int[] list2){
        int[] result = new int[list1.length + list2.length];
        int i = 0;
        int j = 0;
        int x = 0;

        if(list1.length < list2.length){
            while(i < list1.length && j < list2.length){
                if(list1[i] < list2[j]){
                    result[x] = list1[i];
                    x++;
                    i++;
                }
                else if(list2[j] < list1[i]){
                    result[x] = list2[j];
                    x++;
                    j++;
                }
            }
            while(j < list2.length){
                result[x] = list2[j];
                x++;
                j++;
            }
        }
        else if(list2.length < list1.length){
            while(i < list1.length && j < list2.length){
                if(list1[i] < list2[j]){
                    result[x] = list1[i];
                    x++;
                    i++;
                }
                else if(list2[j] < list1[i]){
                    result[x] = list2[j];
                    x++;
                    j++;
                }
            }
            while(i < list1.length){
                result[x] = list1[i];
                x++;
                i++;
            }
        }
        else{
            while(i < list1.length && j < list2.length){
                if(list1[i] < list2[j]){
                    result[x] = list1[i];
                    x++;
                    i++;
                }
                else if(list2[j] < list1[i]){
                    result[x] = list2[j];
                    x++;
                    j++;
                }
            }
            while(i < list1.length){
                result[x] = list1[i];
                x++;
                i++;
            }
        }
        return result;
    }
}