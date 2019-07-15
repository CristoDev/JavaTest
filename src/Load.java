public class Load extends Operation {

        Load(String controler)
        {
            this.setControler(controler);
            this.setElement("LOAD");
        }

        public Load() {
            this.setElement("LOAD");
        }
}
