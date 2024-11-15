package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollegeDepartmentData {

    public static final Map<String, List<String>> ENGINEERING_CURRICULUM = new HashMap<>();
    public static final Map<String, List<String>> INFORMATICS_COMPUTING_SCIENCES_CURRICULUM = new HashMap<>();
    public static final Map<String, List<String>> ARCHITECTURE_FINE_ARTS_DESIGN_CURRICULUM = new HashMap<>();
    public static final Map<String, List<String>> INDUSTRIAL_TECHNOLOGY_CURRICULUM = new HashMap<>();

    static {
        // Engineering Curriculum
        ENGINEERING_CURRICULUM.put("First Year", Arrays.asList(
            "Introduction to Engineering", "Mathematics for Engineers", "Physics for Engineers", 
            "Engineering Drawing", "Introduction to Computer Programming", "English Composition", 
            "General Chemistry", "Engineering Mechanics", "Engineering Materials"));
        
        ENGINEERING_CURRICULUM.put("Second Year", Arrays.asList(
            "Engineering Mathematics", "Electrical Circuits", "Thermodynamics", "Engineering Economics", 
            "Engineering Graphics", "Computer-Aided Design", "Statics and Dynamics", 
            "Engineering Communication", "Fluid Mechanics"));
        
        ENGINEERING_CURRICULUM.put("Third Year", Arrays.asList(
            "Mechanics of Materials", "Electrical Machines", "Control Systems", "Environmental Engineering", 
            "Heat Transfer", "Engineering Electives", "Engineering Ethics and Professionalism", 
            "Engineering Design and Analysis", "Engineering Internship"));
        
        ENGINEERING_CURRICULUM.put("Fourth Year", Arrays.asList(
            "Engineering Management", "Renewable Energy Systems", "Industrial Engineering", 
            "Engineering Project Management", "Engineering Seminar", "Capstone Design Project", 
            "Engineering Electives", "Engineering Law and Regulations"));

        // Informatics and Computing Sciences Curriculum
        INFORMATICS_COMPUTING_SCIENCES_CURRICULUM.put("First Year", Arrays.asList(
            "Introduction to Computer Science", "Programming Fundamentals", "IT Fundamentals", 
            "Discrete Mathematics", "Computer Networks Basics", "Introduction to Information Systems", 
            "Data Structures and Algorithms", "Database Management Systems", "Web Development Basics", 
            "Computing Mathematics", "Operating Systems Fundamentals", "Software Engineering Principles"));
        
        INFORMATICS_COMPUTING_SCIENCES_CURRICULUM.put("Second Year", Arrays.asList(
            "Advanced Programming Concepts", "Computer Architecture", "Systems Analysis and Design", 
            "Cybersecurity Fundamentals", "Object-Oriented Programming", "IT Project Management", 
            "Algorithms and Complexity", "Network Security", "Database Design and Implementation", 
            "Web Development Intermediate", "Human-Computer Interaction", "IT Infrastructure Management"));
        
        INFORMATICS_COMPUTING_SCIENCES_CURRICULUM.put("Third Year", Arrays.asList(
            "Artificial Intelligence Fundamentals", "Cloud Computing", "Software Development Lifecycle", 
            "Mobile Application Development", "Data Mining and Analytics", "IT Governance and Compliance", 
            "Machine Learning", "Distributed Systems", "Advanced Database Management", 
            "Web Development Advanced", "Information Security Management", "Emerging Technologies in IT"));
        
        INFORMATICS_COMPUTING_SCIENCES_CURRICULUM.put("Fourth Year", Arrays.asList(
            "Capstone Project/Thesis Part I", "Professional Ethics in Computing", "Enterprise Systems Integration", 
            "IT Innovation and Entrepreneurship", "Network Administration and Maintenance", 
            "Software Testing and Quality Assurance", "Capstone Project/Thesis Part II", "IT Law and Regulations", 
            "Big Data Technologies", "IT Strategic Planning", "Internship/Practical Training", 
            "Career Development and Industry Trends"));

        // Architecture, Fine Arts and Design Curriculum
        ARCHITECTURE_FINE_ARTS_DESIGN_CURRICULUM.put("First Year", Arrays.asList(
            "Introduction to Architecture", "Architectural Design Basics", "Architectural History", 
            "Drawing Fundamentals", "Design Principles", "Introduction to Fine Arts", "Art History", 
            "Architectural Technology", "Basic Photography"));
        
        ARCHITECTURE_FINE_ARTS_DESIGN_CURRICULUM.put("Second Year", Arrays.asList(
            "Architectural Design Studio I", "Building Construction", "Environmental Design", 
            "Digital Design Tools", "Structural Systems", "Fine Arts Workshop", "Urban Design", 
            "Building Materials", "Architectural Drawing"));
        
        ARCHITECTURE_FINE_ARTS_DESIGN_CURRICULUM.put("Third Year", Arrays.asList(
            "Architectural Design Studio II", "Interior Design", "Landscape Architecture", 
            "Advanced Digital Design", "Sustainable Architecture", "Fine Arts Studio", "Architectural Theory", 
            "Professional Practice", "Cultural Heritage Preservation"));
        
        ARCHITECTURE_FINE_ARTS_DESIGN_CURRICULUM.put("Fourth Year", Arrays.asList(
            "Architectural Design Studio III", "Advanced Architectural Technology", "Urban Planning", 
            "Design Management", "Portfolio Development", "Fine Arts Exhibition", "Architectural Research", 
            "Internship", "Thesis Project"));

        // Industrial Technology Curriculum
        INDUSTRIAL_TECHNOLOGY_CURRICULUM.put("First Year", Arrays.asList(
            "Introduction to Industrial Technology", "Basic Electronics", "Engineering Drawing", 
            "Technical Mathematics", "Workshop Practices", "Computer-Aided Design (CAD)", 
            "Introduction to Manufacturing Processes", "Technical Communication", 
            "Safety and Health in Industry"));
        
        INDUSTRIAL_TECHNOLOGY_CURRICULUM.put("Second Year", Arrays.asList(
            "Industrial Automation", "Materials Science", "Machine Design", "Electrical Machines", 
            "Fluid Mechanics", "Quality Control", "Technical Writing", "Industrial Management", 
            "Internship Preparation"));
        
        INDUSTRIAL_TECHNOLOGY_CURRICULUM.put("Third Year", Arrays.asList(
            "Advanced Manufacturing Technologies", "Robotics and Automation", "Industrial Instrumentation", 
            "Supply Chain Management", "Product Design and Development", "Energy Management", 
            "Industrial Safety Engineering", "Technical Presentations", "Industrial Training"));
        
        INDUSTRIAL_TECHNOLOGY_CURRICULUM.put("Fourth Year", Arrays.asList(
            "Industrial Project Management", "Environmental Management", "Lean Manufacturing", 
            "Human Factors in Industry", "Professional Ethics in Technology", "Industrial Internship", 
            "Capstone Project", "Industry Seminar", "Career Development Workshop"));
    }
    public static List<String> getCurriculum(String department, String yearLevel) {
        Map<String, List<String>> departmentCurriculum = switch (department) {
            case "College of Engineering" -> ENGINEERING_CURRICULUM;
            case "College of Fine Arts and Architecture" -> ARCHITECTURE_FINE_ARTS_DESIGN_CURRICULUM;
            case "College of Informatics and Computing Sciences" -> INFORMATICS_COMPUTING_SCIENCES_CURRICULUM;
            case "College of Information Technology" -> INDUSTRIAL_TECHNOLOGY_CURRICULUM;
            default -> null;
        };
        
        return departmentCurriculum != null ? departmentCurriculum.get(yearLevel) : null;
    }
}

