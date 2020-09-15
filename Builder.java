import java.util.function.Supplier;

class Scratch {

    class CodeBuilder {
        StringBuilder theClass;

        public CodeBuilder(String className) {
            theClass = new StringBuilder(String.format("public class %s\n{\n"
                    , className));
        }

        public CodeBuilder addField(String name, String type) {
            theClass.append(String.format("  public %s %s;\n", type, name));
            return this;
        }

        @Override
        public String toString() {
            return theClass.toString() + "}";
        }
    }

    public void demo() {
        CodeBuilder codeBuilder = new CodeBuilder("Person").addField("name",
                "String").addField("age","int");
        System.out.println(codeBuilder);
        codeBuilder.addField("dateOfBirth","Date");
        System.out.println(codeBuilder);
        Math.max(1,0);

    }

    public static boolean isSingleton(Supplier<Object> func)
    {
        return func.get() == func.get();
    }

    public static void main(String[] args) {
        Scratch scratch = new Scratch();
        scratch.demo();
    }
}