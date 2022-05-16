
@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    private StreamBridge streamBridge;

    @Override
    boolean placeOrder(String orderInfo){
        String[] info = orderInfo.split("\\|");
        int cnt=0;
        String addr = null;
        for(str : info){

        }
    }
}
