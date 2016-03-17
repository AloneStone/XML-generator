
public class Arc {
        
        private int id ;
        private Node nonestart;
        private Node nonefinish;
        private int vitessemax;
        
        public Arc(int id, Node nonestart, Node nonefinish, int vitessemax) {

                this.id = id;
                this.nonestart = nonestart;
                this.nonefinish = nonefinish;
                this.vitessemax = vitessemax;
        }

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public Node getNonestart() {
                return nonestart;
        }

        public void setNonestart(Node nonestart) {
                this.nonestart = nonestart;
        }

        public Node getNonefinish() {
                return nonefinish;
        }

        public void setNonefinish(Node nonefinish) {
                this.nonefinish = nonefinish;
        }

        public int getVitessemax() {
                return vitessemax;
        }

        public void setVitessemax(int vitessemax) {
                this.vitessemax = vitessemax;
        }

}