#��������ConcurrentLinkedQueue����������LinkedBlockingQueue�÷�
��Java���߳�Ӧ���У����е�ʹ���ʺܸߣ�������������ģ�͵���ѡ���ݽṹ���Ƕ���(�Ƚ��ȳ�)��Java�ṩ���̰߳�ȫ��Queue���Է�Ϊ�������кͷ��������У������������еĵ���������BlockingQueue�����������еĵ���������ConcurrentLinkedQueue����ʵ��Ӧ����Ҫ����ʵ����Ҫѡ���������л��߷��������С�
<font color=red>
ע��ʲô���̰߳�ȫ���������Ҫ��ȷ���̰߳�ȫ����˵���̷߳���ͬһ���룬���������ȷ���Ľ����
</font>

���кͲ�������

1��������ָ����ͬʱִ��һ���£��������ܣ������˶��ڲ�ͣ����ǰ�ܣ�
2��������ָ��Դ���޵�����£����߽�������ʹ����Դ������һ��·(����CPU��Դ)ͬʱֻ�ܹ�һ���ˣ�A��һ�κ��ø�B��B���������A ������ʹ�ã�Ŀ�������Ч��

LinkedBlockingQueue
����LinkedBlockingQueueʵ�����̰߳�ȫ�ģ�ʵ�����Ƚ��ȳ������ԣ�����Ϊ�����������ߵ���ѡ��LinkedBlockingQueue ����ָ��������Ҳ���Բ�ָ������ָ���Ļ���Ĭ�������Integer.MAX_VALUE��������Ҫ�õ�put��take������put�����ڶ�������ʱ�������ֱ���ж��г�Ա�����ѣ�take�����ڶ��пյ�ʱ���������ֱ���ж��г�Ա���Ž�����



ConcurrentLinkedQueue
ConcurrentLinkedQueue��Queue��һ����ȫʵ�֣�Queue��Ԫ�ذ�FIFOԭ��������򣮲���CAS����������֤Ԫ�ص�һ���ԡ�
LinkedBlockingQueue��һ���̰߳�ȫ���������У���ʵ����BlockingQueue�ӿڣ�BlockingQueue�ӿڼ̳���java.util.Queue�ӿڣ���������ӿڵĻ�����������take��put�������������������Ƕ��в����������汾��


http://wsmajunfeng.iteye.com/blog/1629354