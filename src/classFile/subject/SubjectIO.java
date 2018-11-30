package classFile.subject;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class SubjectIO {
    private ArrayList<ArrayList<ArrayList<Subject>>> allSubject;

    public SubjectIO() {
        this.allSubject = new ArrayList<>();
        initSubject();
        writeSubject();
    }

    private void initSubject() {
        allSubjectInit();
    }

    private void allSubjectInit() {
        allSubject.add(year1Init());
        allSubject.add(year2Init());
        allSubject.add(year3Init());
        allSubject.add(year4Init());
    }

    // Year 1 init
    private ArrayList<ArrayList<Subject>> year1Init() {
        ArrayList<ArrayList<Subject>> year1 = new ArrayList<>();
        year1.add(year1_1Init());
        year1.add(year1_2Init());

        return year1;
    }

    private ArrayList<Subject> year1_1Init() {
        ArrayList<Subject> year1_1 = new ArrayList<>();
        Subject calculus_1 = new Subject(
                "∫1dx", "01417111",
                "Calculus 1",
                DifficultLevel.QUITE_HARD,
                3,
                "ลิมิตและความต่อเนื่อง" +
                "\n อนุพันธ์และการประยุกต์" +
                "\n เทคนิคการอินทิเกรต");

        Subject introCS = new Subject(
                "0101",
                "01418114",
                "Introduction to computer science",
                DifficultLevel.QUITE_EASY,
                2,
                "พัฒนาการของคอมพิวเตอร์" +
                "\nการแทนข้อมูลในคอมพิวเตอร์" +
                "\nระบบจานวน องค์ประกอบของฮาร์ดแวร์คอมพิวเตอร์" +
                "\nตัววัดสมรรถนะของคอมพิวเตอร์ ซอฟต์แวร์ระบบ" +
                "\nตัวแปลภาษาและภาษาการโปรแกรม การแก้ปัญหา" +
                "\nการออกแบบและพัฒนาขั้นตอนวิธี" +
                "\nเทคนิคการโปรแกรมแบบโครงสร้าง" +
                "\nความซับซ้อนในระบบคอมพิวเตอร์" +
                "\nการจัดองค์การของระบบคอมพิวเตอร์" +
                "\nการตั้งชื่อ สถาปัตยกรรมไคลเอนต์-เซิร์ฟเวอร์" +
                "\nการทาเสมือน สมรรถนะ เครือข่ายคอมพิวเตอร" +
                "\n ความทนทานต่อความผิดพลาด" +
                "\nภาวะครบหน่วย ความต้องกัน" +
                "\nความมั่นคงของสารสนเทศ" +
                "\nระบบคอมพิวเตอร์แบบขนานและกระจาย" +
                "\nการประยุกต์ระบบคอมพิวเตอร์ในปัจจุบัน" +
                "\nจริยธรรมทางคอมพิวเตอร์");

        Subject knowledgeOfTheLand = new Subject(
                "KU",
                "01999111",
                "Knowledge of the land",
                DifficultLevel.EASY,
                2,
                "ประวัติ เอกลักษณ์และอัตลักษณ์ของมหาวิทยาลัยเกษตรศาสตร์ " +
                "\nศาสตร์แห่งแผ่นดินเพื่อความกินดีอยู่ดีของชาติ " +
                "\nการเรียนรู้คนต้นแบบ การสำนึกในความเป็น " +
                "\nพลเมืองไทยพลเมืองโลก " +
                "\nการเสริมสร้างและพัฒนาทักษะในการเรียนรู้และการทำงาน " +
                "\nสู่เป้าหมายภายใต้บริบทความสำนึกดี มุ่งมั่น สร้างสรรค์ สามัคคี");

        Subject funCom = new Subject(
                ".py", "01418113",
                "Fundamental Programing",
                DifficultLevel.MEDIUM, 3,
                "แนวคิดพื้นฐานทางเทคโนโลยีคอมพิวเตอร์และสารสนเทศ " +
                "\nลักษณะเฉพาะและส่วนประกอบของระบบคอมพิวเตอร์ " +
                "\nเครือข่ายคอมพิวเตอร์ อินเทอร์เน็ตและเวิลด์ไวด์เว็บ " +
                "\nการประยุกต์คอมพิวเตอร์ หลักการพัฒนาระบบสารสนเทศ " +
                "\nความมั่นคงและภาวะส่วนตัว จริยธรรมทางคอมพิวเตอร์ ");

        Subject digital = new Subject(
                "IC_",
                "01418131",
                "Digital computer logic",
                DifficultLevel.MEDIUM, 3,
                "การออกแบบวงจรตรรกะเบื้องต้น" +
                "\nการแทนข้อมูลและสารสนเทศโดยสัญญาณดิจิทัล " +
                "\nการลงรหัส การแทนตัวเลขและการคานวณ " +
                "\nสถาปัตยกรรมคอมพิวเตอร์ ");

        Subject eng2 = new Subject(
                "Eng",
                "01355112",
                "English xxxxxx",
                DifficultLevel.ANY,
                3,
                "ภาษาอังกฤษทั่วไป");

        year1_1.add(calculus_1);
        year1_1.add(introCS);
        year1_1.add(knowledgeOfTheLand);
        year1_1.add(funCom);
        year1_1.add(digital);
        year1_1.add(eng2);

        return year1_1;
    }

    private ArrayList<Subject> year1_2Init() {
        ArrayList<Subject> year1_2 = new ArrayList<>();

        Subject calculus_2 = new Subject(
                "∫2dx",
                "01417112",
                "Calculus 2",
                DifficultLevel.QUITE_HARD,
                3,
                "พื้นผิวกำลังสอง อนุพันธ์ย่อย" +
                "\nอินทิกรัลหลายชั้น สมการเชิงอนุพันธ์เบื้องต้น");

        Subject comPro = new Subject(
                "C/C+",
                "01418113",
                "Computer Programming",
                DifficultLevel.MEDIUM,
                3,
                "การโปรแกรมด้วยภาษาระดับสูง" +
                "\nข้อความสั่งรับเข้า/ส่งออก ตัวแปร ข้อความสั่งเงื่อนไข" +
                "\nฟังก์ชัน การกาหนดสาระสาคัญเชิงกระบวนงาน" +
                "\nการทดสอบหน่วยย่อย การโปรแกรมเชิงฟังก์ชัน" +
                "\nการปรากฏซ้า ข้อความสั่งวนซ้า" +
                "\nโครงสร้างข้อมูลพื้นฐาน การกาหนดสาระสาคัญของข้อมูล" +
                "\nการโปรแกรมเชิงวัตถุ คลาส ส่วนต่อประสานและการทาให้เกิดผล" +
                "\nการรับทอด ภาวะพหุสัณฐาน การรับทอดแบบพหุคูณ และมิกซ์อิน ");

        Subject funComputing = new Subject(
                "O(n)",
                "01418132",
                "Fundamentals of Computing",
                DifficultLevel.QUITE_HARD,
                3,
                "ทฤษฎีการคานวณเชิงวิยุต ความน่าจะเป็นและสถิติ" +
                "\nการทาให้เกิดผลและการประยุกต์ในวิทยาการคอมพิวเตอร์ ");

        Subject sport = new Subject(
                "Sprt",
                "01175XXX",
                "Sport",
                DifficultLevel.ANY,
                1,
                "เรียนตามที่เลือก");

        year1_2.add(calculus_2);
        year1_2.add(comPro);
        year1_2.add(funComputing);
        year1_2.add(sport);

        return year1_2;
    }


    // Year 2 init
    private ArrayList<ArrayList<Subject>> year2Init() {
        ArrayList<ArrayList<Subject>> year2 = new ArrayList<>();
        year2.add(year2_1Init());
        year2.add(year2_2Init());

        return year2;
    }

    private ArrayList<Subject> year2_1Init() {
        ArrayList<Subject> year2_1 = new ArrayList<>();

        Subject linear = new Subject(
                "[R]",
                "01417322",
                "Introductory Linear Algebra",
                DifficultLevel.QUITE_HARD,
                3,
                "ปริภูมิเวกเตอร์ การแปลงเชิงเส้นและเมตริกซ์" +
                "\nระบบของสมการเชิงเส้น ค่าเฉพาะ เวกเตอร์เฉพาะ" +
                "\nการทำให้เป็นแนวทแยงมุม การประยุกต์");

        Subject java = new Subject(
                "java",
                "01418211",
                "Software Contruction",
                DifficultLevel.QUITE_HARD,
                3,
                "การโปรแกรมด้วยภาษาเชิงวัตถุที่มีชนิดแบบคงที่" +
                "\nชนิด วัตถุ คลาส คลาสย่อย ส่วนต่อประสาน คลาสเชิงนามธรรม" +
                "\nสิ่งผิดปกติ อรรถศาสตร์การเรียกเมธอด ลาดับชั้นของชนิด" +
                "\nข้อกาหนดของซอฟต์แวร์ ตัวยืนยงในการแทนค่า" +
                "\nการแยกคู่ แผนภาพการขึ้นต่อกันระหว่างโมดูล แผนภาพเชิงพฤติกรรม" +
                "\nการรีแฟกเตอร์ แบบรูปการออกแบบ หลักการออกแบบเชิงวัตถุ" +
                "\nการโปรแกรมเชิงเหตุการณ์ การโปรแกรมในภาวะพร้อมกัน ");

        Subject data = new Subject(
                "Data",
                "01418231",
                "Data Structures",
                DifficultLevel.QUITE_HARD,
                3,
                "โครงสร้างข้อมูล โครงสร้างแฟ้ม และการประมวลผลแฟ้ม" +
                "\nขั้นตอนวิธีสาหรับใช้งานรายการ กองซ้อน แถวคอย ต้นไม้และกราฟ");

        Subject stat = new Subject(
                "∑x/n",
                "01422111",
                "Principles of Statistics",
                DifficultLevel.MEDIUM,
                3,
                "ตัววัดต าแหน่งที่   ตัววัดค่ากลาง  ตัววัดการกระจาย " +
                "\nตัวแปรสุ่ม  และการแจกแจงความน่าจะเป็นของตัวแปรสุ่ม  การแจกแจงทวินาม" +
                "\nารแจกแจงปัวส์ซง การแจกแจงปกติ" +
                "\nการแจกแจงตัวอย่าง  สถิติอนุมานส าหรับประชากรเดียวและสอง" +
                "\nประชากร  การวิเคราะห์ข้อมูลจ านวนนับ  การวิเคราะห์ความแปรปรวนแบบทางเดียว" +
                "\nการวิเคราะห์การถดถอยเชิงเส้นแบบง่าย");

        year2_1.add(linear);
        year2_1.add(java);
        year2_1.add(data);
        year2_1.add(stat);

        return year2_1;
    }

    private ArrayList<Subject> year2_2Init() {
        ArrayList<Subject> year2_2 = new ArrayList<>();

        Subject dataBase = new Subject(
                "DB",
                "01418211",
                "Fundamentals of Database Systems",
                DifficultLevel.HARD,
                3,
                "แนวคิดเกี่ยวกับฐานข้อมูลเบื้องต้น" +
                "\nเป้าหมายของระบบจัดการฐานข้อมูล" +
                "\nความไม่พึ่งพิงของข้อมูล บูรณภาพและความเชื่อถือได้" +
                "\nการจัดองค์การเชิงตรรกะและเชิงกายภาพ" +
                "\nเค้าร่างและเค้าร่างย่อย ตัวแบบข้อมูลเชิงลาดับชั้น" +
                "\nเชิงข่ายงาน และเชิงสัมพันธ์ บรรทัดฐานข้อมูล" +
                "\nภาษานิยามข้อมูลพจนานุกรมข้อมูล" +
                "\nเครื่องช่วยตอบข้อซักถาม" +
                "\nการจัดแฟ้มข้อมูล ความปลอดภัยของแฟ้มข้อมูล ");

        Subject algo = new Subject(
                "n^2",
                "01418232",
                "Algorithms Design and Analysis",
                DifficultLevel.HARD,
                3,
                "แนวคิดพื้นฐานของขั้นตอนวิธี" +
                "\nการวิเคราะห์ขั้นตอนวิธีในเชิงคณิตศาสตร์" +
                "\nการวิเคราะห์ขั้นตอนวิธีการเรียงลาดับและการค้นหา" +
                "\nเทคนิคเชิงขั้นตอนวิธี วิธีการออกแบบขั้นตอนวิธี ");

        Subject assem = new Subject(
                "0001",
                "01418233",
                "Algorithm Design and Analysis",
                DifficultLevel.HARD,
                4,
                "โครงสร้างของภาษาแอสเซมบลี" +
                "\nเทคนิคการกาหนดเลขที่อยู่" +
                "\nแฟ้มข้อมูลสาหรับรับเข้าและส่งออก" +
                "\nการแบ่งส่วนของโปรแกรมและการเชื่อมโยง" +
                "\nการสร้างโปรแกรมภาษาแอสเซมบลี" +
                "\nลักษณะเฉพาะของสถาปัตยกรรมคอมพิวเตอร์" +
                "\nผลที่มีต่อการออกแบบและสมรรถนะของระบบ" +
                "\nภาวะถ่วงดุลระหว่างราคาต่อสมรรถนะ" +
                "\nการออกแบบชุดคาสั่ง ตัวประมวลผลกลาง" +
                "\nระบบรับส่งข้อมูล การทางานแบบสายท่อ" +
                "\nเวกเตอร์และสถาปัตยกรรมแบบริกส์ สถาปัตยกรรมแบบขนาน ");

        year2_2.add(dataBase);
        year2_2.add(algo);
        year2_2.add(assem);

        return year2_2;
    }


    // Year 3 init
    private ArrayList<ArrayList<Subject>> year3Init() {
        ArrayList<ArrayList<Subject>> year3 = new ArrayList<>();
        year3.add(year3_1Init());
        year3.add(year3_2Init());

        return year3;
    }

    private ArrayList<Subject> year3_1Init() {
        ArrayList<Subject> year3_1 = new ArrayList<>();
        Subject system = new Subject(
                "Sys",
                "01418321",
                "System Analysis and Design",
                DifficultLevel.HARD,
                3,
                "ขั้นตอนวิเคราะห์เบื้องต้น เครื่องมือในการวิเคราะห์ระบบ" +
                        "\nผังระบบงาน ตารางการตัดสินและต้นไม้การตัดสิน" +
                        "\nการศึกษาความเป็นไปได้ของปัญหา" +
                        "\nการวิเคราะห์ความคุ้มค่าในการลงทุน นาเข้า " +
                        "\nส่งออกและการออกแบบ" +
                        "\nการออกแบบวิธีการประมวลผลด้วยคอมพิวเตอร์" +
                        "\nการทาเอกสาร การนาไปใช้และการประเมินผล" +
                        "\nการพิสูจน์ การออกแบบ กรณีศึกษา ");

        Subject operating = new Subject(
                "OS",
                "01418331",
                "Operating Systems",
                DifficultLevel.QUITE_EASY,
                4,
                "พัฒนาการของสถาปัตยกรรมคอมพิวเตอร์และระบบปฏิบัติการ" +
                "\nโครงสร้างระบบปฏิบัติการ กระบวนการและสายโยงใย" +
                "\nการจัดกาหนดการ การติดตาย" +
                "\nลาดับขั้นของหน่วยความจา การจัดการหน่วยความจา" +
                "\nหน่วยความจาเสมือน การจัดการระบบแฟ้ม" +
                "\nการจัดการระบบรับเข้าและส่งออก" +
                "\nความมั่นคง การป้องกัน ระบบปฏิบัติการแบบกระจาย ");

        Subject intel = new Subject(
                "Intl",
                "01418341",
                "Computer Application in Linear Optimization and Network Analysis",
                DifficultLevel.MEDIUM, 3,
                "การโปรแกรมขั้นตอนวิธีสาหรับการหาค่าเหมาะที่สุดเชิงเส้น" +
                "\nวิธีซิมเพล็กซ์ และวิธีซิมเพล็กซ์แบบปรับปรุง" +
                "\nการวิเคราะห์เครือข่าย เทคนิคการประเมินค่าและควบคุมโครงการ" +
                "\nระเบียบวิธีวิถีวิกฤต การโปรแกรมสาหรับทฤษฎีเกม ");

        Subject seminar = new Subject(
                "Semi",
                "01418497",
                "Seminar",
                DifficultLevel.HARD,
                1,
                "การนาเสนอและอภิปรายหัวข้อที่น่าสนใจทางวิทยาการคอมพิวเตอร์ ในระดับปริญญาตรี ");

        year3_1.add(system);
        year3_1.add(operating);
        year3_1.add(intel);
        year3_1.add(seminar);

        return year3_1;
    }

    private ArrayList<Subject> year3_2Init() {
        ArrayList<Subject> year3_2 = new ArrayList<>();

        Subject security = new Subject(
                "Secu",
                "01418322",
                "Computer System and Communication Network Security",
                DifficultLevel.MEDIUM,
                3,
                "เทคนิคการเข้ารหัส เทคนิคการพิสูจน์ตัวจริง" +
                "\nการบริหารความมั่นคง" +
                "\nประเด็นทางกฎหมายและจริยธรรมในระบบความมั่นคงของคอมพิวเตอร์และเครือข่ายการสื่อสาร");

        Subject auto = new Subject(
                "a->b",
                "01418333",
                "Automata Theory",
                DifficultLevel.MEDIUM,
                2,
                "แนวคิดเรื่องภาวะจากัด เครื่องรับรู้ ข้อความปรกติ" +
                "\nสมบัติปิด เครื่องจักรชนิดลาดับ และเครื่องสื่อนาภาวะจากัด" +
                "\nการหาภาวะต่าสุด ไวยากรณ์ของภาษารูปนัย" +
                "\nภาวะที่เอื้อต่อการคานวณ และเครื่องจักรทัวริง ");

        Subject tech = new Subject(
                "...",
                "01418334",
                "Compiler Techniques",
                DifficultLevel.HARD,
                2,
                "ตัวแปลโปรแกรมและโปรแกรมแปลภาษา เฟสของตัวแปลโปรแกรม" +
                "\nสัญกรณ์และแนวคิดของภาษาและไวยากรณ์" +
                "\nการวิเคราะห์ศัพท์ ต้นไม้แจงส่วนและการแปลง" +
                "\nความกากวม เทคนิคการแจงส่วน" +
                "\nตารางสัญลักษณ์ การแทนระหว่างกลาง" +
                "\nการวิเคราะห์ความหมายและการก่อกาเนิดรหัส ");

        year3_2.add(security);
        year3_2.add(tech);
        year3_2.add(auto);
        year3_2.add(tech);

        return year3_2;
    }


    // Year 4 init
    private ArrayList<ArrayList<Subject>> year4Init() {
        ArrayList<ArrayList<Subject>> year4 = new ArrayList<>();
        year4.add(year4_1Init());
        year4.add(year4_2Init());

        return year4;
    }

    private ArrayList<Subject> year4_1Init() {
        ArrayList<Subject> year4_1 = new ArrayList<>();

        Subject co_op = new Subject(
                "Co",
                "01418490",
                "Cooperative Education",
                DifficultLevel.HARD,
                6,
                "การปฏิบัติงานในลักษณะพนักงานชั่วคราว" +
                "\nตามโครงงานที่ได้รับมอบหมายตลอดจนการจัดทารายงานและการนาเสนอ");

        year4_1.add(co_op);

        return year4_1;
    }

    private ArrayList<Subject> year4_2Init() {
        ArrayList<Subject> year4_2 = new ArrayList<>();

        Subject cs = new Subject(
                "CS",
                "01418499",
                "Computer Science Project",
                DifficultLevel.HARD,
                3,
                "โครงงานที่น่าสนใจในแขนงต่างๆ ของวิทยาการคอมพิวเตอร์");

        year4_2.add(cs);

        return year4_2;
    }


    public void writeSubject() {
        try {
            File subjectData = new File("SubjectData.json");

//            if (!subjectData.exists()) {
                Gson gson = new Gson();
                String json = gson.toJson(allSubject);
                PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(subjectData)));
                writer.println(json);
                writer.close();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    public static ArrayList<Subject> readSubject(String filename) {
//        ArrayList<Subject> subjects = null;
//        try {
//            Gson gson = new Gson();
//            BufferedReader reader = new BufferedReader(new FileReader(filename));
//            subjects = gson.fromJson(reader, new TypeToken<ArrayList<Subject>>(){}.getType());
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        return subjects;
//    }

    public ArrayList<ArrayList<ArrayList<Subject>>> getAllSubject() {
        return allSubject;
    }

    public ArrayList<ArrayList<Subject>> getSubjectInYear(int year) {
        ArrayList<ArrayList<Subject>> subjectInYear = null;
        switch (year) {
            case 1:
                subjectInYear = allSubject.get(0);
                break;
            case 2:
                subjectInYear = allSubject.get(1);
                break;
            case 3:
                subjectInYear = allSubject.get(2);
                break;
            case 4:
                subjectInYear = allSubject.get(3);
                break;
        }
        return subjectInYear;
    }

    public ArrayList<Subject> getSubjectInTerm(int year, int term) {
        ArrayList<ArrayList<Subject>> subjectInYear = getSubjectInYear(year);
        ArrayList<Subject> subjectInTerm = null;

        switch (term) {
            case 1:
                subjectInTerm = subjectInYear.get(0);
                break;
            case 2:
                subjectInTerm = subjectInYear.get(1);
                break;
        }
        return subjectInTerm;
    }
}
