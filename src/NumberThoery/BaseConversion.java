package NumberThoery;

public class BaseConversion {

    public static void main(String[] args) {
        System.out.printf("Base %d Conversion of value %f: %f", 4, 24.25, baseConvert(24.25, 4));

        System.out.printf("\n Decimal Convert of value %d from the base %d : %d", 120, 4, decimalConvert(120, 4));
    }

    private static double baseConvert(double decimal, int base) {

        int intPart=(int) decimal;
        double fractional= decimal-intPart;
        StringBuilder intSb = new StringBuilder();
        while (intPart != 0) {
            intSb.append(intPart % base);
            intPart = intPart / base;
        }
        intSb.reverse();

        StringBuilder fracSb=new StringBuilder();
        if(fractional>0){
            int count=0;
            while(count<2 && fractional>0){
                fractional*=base;
                int intValue=(int) fractional;
                fracSb.append(intValue);
                fractional-=intValue;
                count++;
            }

        }

        String value=decimal- Math.floor(decimal)>0? intSb.append('.').append(fracSb.toString()).toString() :intSb.toString();
        return Double.parseDouble(value);
    }

    private static int decimalConvert(int value, int base) {
        int p = 0;
        int sum = 0;
        while (value != 0) {
            sum = sum + ((value % 10) * (int) Math.pow(base, p));
            p++;
            value /= 10;
        }
        return sum;
    }
}
