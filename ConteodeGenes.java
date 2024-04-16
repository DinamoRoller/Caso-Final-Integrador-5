public class ConteodeGenes {

    public static void main(String[] args) {
        String dna = "ATGATGCGTATGCTAGCATGCTAG";
        int count = countGenes(dna);
        System.out.println("Número total de genes en la cadena de ADN: " + count);
    }

    public static int countGenes(String dna) {
        int index = dna.indexOf("ATG");
        if (index == -1) {
            return 0;
        } else {
            return 1 + countGenesAfterStart(dna.substring(index + 3));
        }
    }

    public static int countGenesAfterStart(String dna) {
        int index = dna.indexOf("ATG");
        if (index == -1) {
            return 0;
        } else {
            return 1 + countGenesAfterStart(dna.substring(index + 3));
        }
    }
}
