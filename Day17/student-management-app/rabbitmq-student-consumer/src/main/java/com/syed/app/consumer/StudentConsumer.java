package com.syed.app.consumer;



@Service
public class StudentConsumer {
    public static final Logger logger = LoggerFactory.getLogger(StudentConsumer.class.getName());

    @Autowired
    private StudentService studentService;

    @Bean
    public Jackson2JsonMessageConverter jackson2JsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // save the student object received in the queue


    @RabbitListener(queues ="${rabbitmq.student.queue.name}" )
    public void saveStudent(Student student) {
        logger.info("Received Student object to save: {}", student);
        String response = studentService.saveStudent(student);
        logger.info("Response: {}", response);
    }

    // Method to delete the student by name received from the queue
    @RabbitListener(queues ="${rabbitmq.queue.name}")
    public void deleteStudent(String studentName) {
        logger.info("Received request to delete Student with name: {}", studentName);
        String response = studentService.deleteStudent(studentName);
        logger.info("Response: {}", response);    }
}
