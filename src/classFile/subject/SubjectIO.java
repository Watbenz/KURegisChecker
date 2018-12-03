package classFile.subject;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;

public class SubjectIO {
    private ArrayList<ArrayList<ArrayList<Subject>>> allSubject;
    private File subjectData;

    public SubjectIO() {
        this.subjectData = new File("SubjectData.json");
        initSubject();
    }

    private void initSubject() {
        if (!subjectData.exists()) {
            writeAllSubject();
        }
        else {
            readSubject();
        }
    }

    private void allSubjectInit() {
        this.allSubject = new ArrayList<>();
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
                "\n เทคนิคการอินทิเกรต"
        );

        Subject funCom = new Subject(
                ".py",
                "01418112",
                "Fundamental Programing Concepts",
                DifficultLevel.MEDIUM,
                3,
                "แนวคิดพื้นฐานทางเทคโนโลยีคอมพิวเตอร์และสารสนเทศ " +
                        "\nลักษณะเฉพาะและส่วนประกอบของระบบคอมพิวเตอร์ " +
                        "\nเครือข่ายคอมพิวเตอร์ อินเทอร์เน็ตและเวิลด์ไวด์เว็บ " +
                        "\nการประยุกต์คอมพิวเตอร์ หลักการพัฒนาระบบสารสนเทศ " +
                        "\nความมั่นคงและภาวะส่วนตัว จริยธรรมทางคอมพิวเตอร์ "
        );

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
                "\nจริยธรรมทางคอมพิวเตอร์"
        );

        Subject digital = new Subject(
                "IC_",
                "01418131",
                "Digital computer logic",
                DifficultLevel.MEDIUM, 3,
                "การออกแบบวงจรตรรกะเบื้องต้น" +
                        "\nการแทนข้อมูลและสารสนเทศโดยสัญญาณดิจิทัล " +
                        "\nการลงรหัส การแทนตัวเลขและการคานวณ " +
                        "\nสถาปัตยกรรมคอมพิวเตอร์ "
        );

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
                "\nสู่เป้าหมายภายใต้บริบทความสำนึกดี มุ่งมั่น สร้างสรรค์ สามัคคี"
        );

        Subject eng = new Subject(
                "Eng",
                "01xxxxxx",
                "(สาระภาษาฯ - ภาษาต่างประเทศ 1)",
                DifficultLevel.ANY,
                3,
                "ภาษาอังกฤษทั่วไป"
        );

        Subject thai = new Subject(
                "Thai",
                "01xxxxxx",
                "(สาระภาษาฯ - ภาษาไทย)",
                DifficultLevel.ANY,
                3,
                "กลุ่มรายวิชาภาษาไทย"
        );


        year1_1.add(calculus_1);
        year1_1.add(introCS);
        year1_1.add(knowledgeOfTheLand);
        year1_1.add(funCom);
        year1_1.add(digital);
        year1_1.add(eng);
        year1_1.add(thai);

        addYearAndTermEachSubject(year1_1, 1, 1);

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
                "\nอินทิกรัลหลายชั้น สมการเชิงอนุพันธ์เบื้องต้น"
        );

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
                "\nการรับทอด ภาวะพหุสัณฐาน การรับทอดแบบพหุคูณ และมิกซ์อิน "
        );

        Subject funComputing = new Subject(
                "O(n)",
                "01418132",
                "Fundamentals of Computing",
                DifficultLevel.QUITE_HARD,
                3,
                "ทฤษฎีการคานวณเชิงวิยุต ความน่าจะเป็นและสถิติ" +
                "\nการทาให้เกิดผลและการประยุกต์ในวิทยาการคอมพิวเตอร์ "
        );

        Subject sport = new Subject(
                "Sprt",
                "01175xxx",
                "(สาระอยู่ดีมีสุข - พลศึกษา)",
                DifficultLevel.ANY,
                1,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject manage = new Subject(
                "Spap",
                "01xxxxxx",
                "(สาระศาสตร์แห่งผู้ประกอบการณ์)",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject people = new Subject(
                "Life",
                "01xxxxxx",
                "(สาระพลเมืองไทยฯ)",
                DifficultLevel.ANY,
                1,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject free = new Subject(
                "?",
                "01xxxxxx",
                "(สาระสุนทรียศาสตร์)",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        year1_2.add(calculus_2);
        year1_2.add(comPro);
        year1_2.add(funComputing);
        year1_2.add(sport);
        year1_2.add(manage);
        year1_2.add(people);
        year1_2.add(free);

        addYearAndTermEachSubject(year1_2, 1, 2);

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
                "\nการทำให้เป็นแนวทแยงมุม การประยุกต์"
        );

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
                "\nการโปรแกรมเชิงเหตุการณ์ การโปรแกรมในภาวะพร้อมกัน "
        );

        Subject data = new Subject(
                "Data",
                "01418231",
                "Data Structures",
                DifficultLevel.QUITE_HARD,
                3,
                "โครงสร้างข้อมูล โครงสร้างแฟ้ม และการประมวลผลแฟ้ม" +
                "\nขั้นตอนวิธีสาหรับใช้งานรายการ กองซ้อน แถวคอย ต้นไม้และกราฟ"
        );

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
                "\nการวิเคราะห์การถดถอยเชิงเส้นแบบง่าย"
        );

        Subject com = new Subject(
                "Lib",
                "01xxxxxx",
                "(สาระภาาาฯ - II/Computer)",
                DifficultLevel.ANY,
                1,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject sport = new Subject(
                "sprt",
                "01xxxxxx",
                "(สาระอยู่ดีมีสุข)",
                DifficultLevel.ANY,
                2,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject sci = new Subject(
                "Sci",
                "01xxxxxx",
                "(ทั้ง 5 สาระ - คณะวิทยาศาสตร์)",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        year2_1.add(linear);
        year2_1.add(java);
        year2_1.add(data);
        year2_1.add(stat);
        year2_1.add(com);
        year2_1.add(sport);
        year2_1.add(sci);

        addYearAndTermEachSubject(year2_1, 2, 1);

        return year2_1;
    }

    private ArrayList<Subject> year2_2Init() {
        ArrayList<Subject> year2_2 = new ArrayList<>();

        Subject dataBase = new Subject(
                "DB",
                "01418221",
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
                "\nการจัดแฟ้มข้อมูล ความปลอดภัยของแฟ้มข้อมูล "
        );

        Subject algo = new Subject(
                "n^2",
                "01418232",
                "Algorithms Design and Analysis",
                DifficultLevel.HARD,
                3,
                "แนวคิดพื้นฐานของขั้นตอนวิธี" +
                "\nการวิเคราะห์ขั้นตอนวิธีในเชิงคณิตศาสตร์" +
                "\nการวิเคราะห์ขั้นตอนวิธีการเรียงลาดับและการค้นหา" +
                "\nเทคนิคเชิงขั้นตอนวิธี วิธีการออกแบบขั้นตอนวิธี "
        );

        Subject assem = new Subject(
                "0001",
                "01418233",
                "Assembly Language and Computer Architecture",
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
                "\nเวกเตอร์และสถาปัตยกรรมแบบริกส์ สถาปัตยกรรมแบบขนาน "
        );

        Subject major = new Subject(
                "M",
                "01418xxx",
                "Major Electives 1",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject eng = new Subject(
                "Eng",
                "01xxxxxx",
                "(สาระภาษาฯ - ภาษาต่างประเทศ 2)",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject sci = new Subject(
                "Sci",
                "01xxxxxx",
                "(ทั้ง 5 สาระ - คณะวิทยาศาสตร์)",
                DifficultLevel.ANY,
                2,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        year2_2.add(dataBase);
        year2_2.add(algo);
        year2_2.add(assem);
        year2_2.add(major);
        year2_2.add(eng);
        year2_2.add(sci);

        addYearAndTermEachSubject(year2_2, 2, 2);

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
                "SA",
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
                        "\nการพิสูจน์ การออกแบบ กรณีศึกษา "
        );

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
                "\nความมั่นคง การป้องกัน ระบบปฏิบัติการแบบกระจาย "
        );

        Subject intel = new Subject(
                "IP",
                "01418341",
                "Computer Application in Linear Optimization and Network Analysis",
                DifficultLevel.MEDIUM, 3,
                "การโปรแกรมขั้นตอนวิธีสาหรับการหาค่าเหมาะที่สุดเชิงเส้น" +
                "\nวิธีซิมเพล็กซ์ และวิธีซิมเพล็กซ์แบบปรับปรุง" +
                "\nการวิเคราะห์เครือข่าย เทคนิคการประเมินค่าและควบคุมโครงการ" +
                "\nระเบียบวิธีวิถีวิกฤต การโปรแกรมสาหรับทฤษฎีเกม "
        );

        Subject seminar = new Subject(
                "Semi",
                "01418497",
                "Seminar",
                DifficultLevel.HARD,
                1,
                "การนาเสนอและอภิปรายหัวข้อที่น่าสนใจทางวิทยาการคอมพิวเตอร์ ในระดับปริญญาตรี "
        );

        Subject major = new Subject(
                "M",
                "01418xxx",
                "Major Electives 2",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject eng = new Subject(
                "Eng",
                "01xxxxxx",
                "(สาระภาษาฯ - ภาษาต่างประเทศ 3)",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        year3_1.add(system);
        year3_1.add(operating);
        year3_1.add(intel);
        year3_1.add(seminar);
        year3_1.add(major);
        year3_1.add(eng);

        addYearAndTermEachSubject(year3_1, 3, 1);

        return year3_1;
    }

    private ArrayList<Subject> year3_2Init() {
        ArrayList<Subject> year3_2 = new ArrayList<>();

        Subject security = new Subject(
                "Secu",
                "01418332",
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

        Subject compiler = new Subject(
                "Comp",
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

        Subject prin = new Subject(
                "CC",
                "01418351",
                "Principle in CCs & Cloud Computing",
                DifficultLevel.MEDIUM,
                3,
                "แนวคิดของเครือข่าวยการสื่อสารแบบมีสาย ไร้สาย และเซลลูลาร์ \n" +
                        "องค์ประกอบของการสื่อสาร\n" +
                        "คอมพิวเตอร์และเครือข่าย ชนิดของเครือข่ายคอมพิวเตอร์ \n" +
                        "มาตรฐานและระดับชั้นโพรโทคอล โพรโทคอลชั้นโปรแกรม\n" +
                        "ประยุกต์ สถาปัตยกรรมและการโปรแกรมโปรแกรมประยุกต์บนเครือข่าย \n" +
                        "โพรโทคอลชั้นทรานสปอร์ต เครือข่ายแบบ\n" +
                        "กำหนดโดยซอฟต์แวร์ การประมวลผลบนคลาวด์ องค์ประกอบและบริการ"
        );

        Subject co_op = new Subject(
                "CO",
                "01418390",
                "Co-op. Education Preparation",
                DifficultLevel.QUITE_EASY,
                1,
                "หลักการ แนวคิด และกระบวนการของสหกิจศึกษา \n" +
                        "ระเบียบข้อบังคับที่เกที่ยวข้อง ความรู้พื้นฐานและ\n" +
                        "เทคนิคในการสมัครงานและปฏิบัติงาน การสื่อสารและมนุษยสัมพันธ์ \n" +
                        "การพัฒนาบุคลิกภาพ ระบบการบริหารคุณภาพ\n" +
                        "ในสถานประกอบการ เทคนิคการนำเสนอ การเขียนรายงาน"
        );

        Subject major = new Subject(
                "M",
                "01418xxx",
                "Major Electives 3",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject free = new Subject(
                "Free",
                "01xxxxxx",
                "Free Electives 1",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        year3_2.add(security);
        year3_2.add(compiler);
        year3_2.add(auto);
        year3_2.add(prin);
        year3_2.add(co_op);
        year3_2.add(major);
        year3_2.add(free);

        addYearAndTermEachSubject(year3_2, 3, 2);

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
                "\nตามโครงงานที่ได้รับมอบหมายตลอดจนการจัดทารายงานและการนาเสนอ"
        );

        year4_1.add(co_op);

        addYearAndTermEachSubject(year4_1, 4, 1);

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
                "โครงงานที่น่าสนใจในแขนงต่างๆ ของวิทยาการคอมพิวเตอร์"
        );

        Subject major4 = new Subject(
                "M",
                "01418xxx",
                "Major Electives 4",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject major5 = new Subject(
                "M",
                "01418xxx",
                "Major Electives 5",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject major6 = new Subject(
                "M",
                "01418xxx",
                "Major Electives 6",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        Subject free = new Subject(
                "Free",
                "01xxxxxx",
                "Free Electives 2",
                DifficultLevel.ANY,
                3,
                "รายวิชาขึ้นอยู่กับวิชาที่ลงเรียน"
        );

        year4_2.add(cs);
        year4_2.add(major4);
        year4_2.add(major5);
        year4_2.add(major6);
        year4_2.add(free);

        addYearAndTermEachSubject(year4_2, 4, 2);

        return year4_2;
    }

    private void addYearAndTermEachSubject(ArrayList<Subject> subjectInTerm, int year, int term) {
        for (Subject each: subjectInTerm) {
            each.setYear(year);
            each.setTerm(term);
        }
    }

    public void update() {
        writeSubject();
    }

    public void writeAllSubject() {
        allSubjectInit();
        addAllPrevious();
        writeSubject();
    }

    public void resetData() {
        for (ArrayList<ArrayList<Subject>> year: allSubject) {
            for (ArrayList<Subject> term: year) {
                for (Subject eachSubject: term) {
                    if (eachSubject.isFinish()) {
                        eachSubject.setFinish(false);
                    }
                }
            }
        }
    }

    private void addAllPrevious() {
        Subject python = findSubjectFromId(1, 1, "01418112");
        Subject intro = findSubjectFromId(1, 1, "01418114");
        python.addPrevious(intro);

        Subject calculus_1 = findSubjectFromId(1, 1, "01417111");
        Subject calculus_2 = findSubjectFromId(1, 2, "01417112");
        Subject linear = findSubjectFromId(2, 1, "01417322");
        calculus_2.addPrevious(calculus_1);
        linear.addPrevious(calculus_2);
        linear.addPrevious(calculus_2);

        Subject comPro = findSubjectFromId(1, 2, "01418113");
        comPro.addPrevious(python);

        Subject java = findSubjectFromId(2, 1, "01418211");
        java.addPrevious(comPro);

        Subject data = findSubjectFromId(2, 1, "01418231");
        data.addPrevious(comPro);

        Subject database = findSubjectFromId(2, 2, "01418221");
        database.addPrevious(comPro);

        Subject assembly = findSubjectFromId(2, 2, "01418233");
        Subject digital = findSubjectFromId(1, 1, "01418131");
        assembly.addPrevious(comPro);
        assembly.addPrevious(digital);

        Subject algorithm = findSubjectFromId(2, 2, "01418232");
        Subject fundCom = findSubjectFromId(1, 2, "01418132");
        algorithm.addPrevious(fundCom);
        algorithm.addPrevious(data);

        Subject sa = findSubjectFromId(3, 1, "01418321");
        sa.addPrevious(java);
        sa.addPrevious(database);

        Subject os = findSubjectFromId(3, 1, "01418331");
        os.addPrevious(assembly);

        Subject seminar = findSubjectFromId(3, 1, "01418497");
        seminar.addPrevious(database);
        seminar.addPrevious(algorithm);
        seminar.addPrevious(assembly);

        Subject co_op = findSubjectFromId(3, 2, "01418390");
        co_op.addPrevious(sa);

        Subject security = findSubjectFromId(3, 2, "01418332");
        security.addPrevious(os);

        Subject cc = findSubjectFromId(3, 2, "01418351");
        cc.addPrevious(os);

        Subject autometa = findSubjectFromId(3, 2, "01418333");
        autometa.addPrevious(fundCom);

        Subject compiler = findSubjectFromId(3, 2, "01418334");
        compiler.addPrevious(autometa);

        Subject co_opEdu = findSubjectFromId(4, 1, "01418490");
        co_opEdu.addPrevious(co_op);

        Subject csProject = findSubjectFromId(4, 2, "01418499");
        csProject.addPrevious(sa);
    }

    public boolean isPreviousFinish(Subject subject) {
        ArrayList<String> allPrevious = subject.getPrevious();

        for (String each: allPrevious) {
            Subject eachSubject = getSubjectFromFormat(each);
            if (!eachSubject.isFinish()) {
                return false;
            }
        }
        return true;
    }

    public void setPreviousToFalse(Subject subject) {
        ArrayList<String> allPrevious = subject.getPrevious();

        for (String each: allPrevious) {
            Subject eachSubject = getSubjectFromFormat(each);
            if (!eachSubject.isFinish()) {
                subject.setFinish(false);
            }
        }
    }

    public ArrayList<Subject> getPreviousAsArrayList(Subject subject) {
        return getAsArrayList(subject.getPrevious());
    }

    public ArrayList<Subject> getNextAsArrayList(Subject subject) {
        return getAsArrayList(subject.getNext());
    }

    private ArrayList<Subject> getAsArrayList(ArrayList<String> subjectArray) {
        ArrayList<Subject> output = new ArrayList<>();

        for (String each: subjectArray) {
            Subject eachSubject = getSubjectFromFormat(each);
            output.add(eachSubject);
        }
        return output;
    }

    public Subject getSubjectFromFormat(String subjectFormat) {
        String[] format = subjectFormat.split("_");
        int year = Integer.parseInt("" + format[0].charAt(0));
        int term = Integer.parseInt("" + format[0].charAt(1));
        String id = format[1];
        return findSubjectFromId(year, term, id);
    }

    private void writeSubject() {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(allSubject);
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(subjectData)));
            writer.println(json);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readSubject() {
        try {
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new FileReader(subjectData));
            allSubject = gson.fromJson(reader, new TypeToken<ArrayList<ArrayList<ArrayList<Subject>>>>(){}.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Subject findSubjectFromId(int year, int term, String id) {
        ArrayList<Subject> subjectInTerm = getSubjectInTerm(year, term);
        for (Subject each: subjectInTerm) {
            if (each.getSubjectId().equals(id)) {
                return each;
            }
        }
        throw new IndexOutOfBoundsException("Cannot find id in array");
    }

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
