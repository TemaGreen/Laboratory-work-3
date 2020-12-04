import java.io.*;

public class Main
{
    public static void main(String[] args) throws DuplicateSubjectException, FileNotFoundException, IOException, ClassNotFoundException{
        Pupil boy = new Schoolboy("Хамидуллин", 3);
        boy.setMark(0,3);
        boy.setMark(1,4);
        boy.setMark(2,5);
        boy.setSubject(0, "Математика");
        boy.setSubject(1, "Русский");
        boy.setSubject(2, "Физика");


        FileOutputStream out1 = new FileOutputStream("file");
        Pupils.outputPupil(boy, out1);
        out1.close();

        FileInputStream in1 = new FileInputStream("file");
        Pupil clone1 = Pupils.inputPupil(in1);
        Pupils.printMarks(clone1);
        Pupils.printSubjects(clone1);
        in1.close();

        FileWriter out2 = new FileWriter("file");
        Pupils.writePupil(boy, out2);
        out2.close();

        FileReader in2 = new FileReader("file");
        Pupil clone2 = Pupils.readPupil(in2);
        Pupils.printMarks(clone2);
        Pupils.printSubjects(clone2);
        in2.close();

        ObjectOutputStream out3 = new ObjectOutputStream(new FileOutputStream("file"));
        out3.writeObject(boy);
        out3.close();

        ObjectInputStream in3 = new ObjectInputStream(new FileInputStream("file"));
        Pupil clone3 = (Schoolboy) in3.readObject();
        Pupils.printMarks(clone3);
        Pupils.printSubjects(clone3);
        in3.close();

    }
}