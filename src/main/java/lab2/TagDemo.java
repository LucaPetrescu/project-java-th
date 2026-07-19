package lab2;

import java.util.Objects;

public class TagDemo {

    static class Tag {
        private String name;
        private String category;

        Tag(String name, String category) {
            this.name = name;
            this.category = category;
        }

        void setCategory(String category) { this.category = category; }

        @Override
        public boolean equals(Object o) {
            if(o == this) {
                return true;
            }
            if(!(o instanceof Tag)) {
                return false;
            }
            Tag t = (Tag) o;
            return Objects.equals(name, t.name)
                && Objects.equals(category, t.category);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, category);
        }

        @Override
        public String toString() { return name + ":" + category; }
    }
    
}
