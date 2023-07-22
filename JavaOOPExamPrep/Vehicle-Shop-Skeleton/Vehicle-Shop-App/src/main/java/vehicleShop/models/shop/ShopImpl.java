package vehicleShop.models.shop;

import vehicleShop.models.tool.Tool;
import vehicleShop.models.vehicle.Vehicle;
import vehicleShop.models.worker.Worker;

import java.util.Collection;
import java.util.List;

public class ShopImpl implements Shop{
    @Override
    public void make(Vehicle vehicle, Worker worker) {
        //•	The worker starts making the vehicle. This is only possible if the worker has strength and a tool that isn't broken.
        //•	Keep working until the vehicle is done or the worker has strength (and tools to use).
        //•	If at some point the power of the current tool reaches or drops below 0, meaning it is broken,
        // then the worker should take the next tool from its collection, if it has any left.
        Collection<Tool> tools = worker.getTools();//взимаме списъка с инструменти
        while (worker.canWork() && !vehicle.reached()&& tools.iterator().hasNext()){
            //tools.iterator().hasNext()->пускаме итератор
            Tool currentTool = tools.iterator().next();
            //за да може нашия инструмент да построи колата ние : намаляме силата, worker - го пускаме да работи и колата я пускаме да се прави
            currentTool.decreasesPower();//намаляме силата
            worker.working();//worker - го пускаме да работи
            vehicle.making();//колата я пускаме да се прави

            //ако инструментът се счупи
            if (currentTool.isUnfit()){
                //ако инструментът се счупи минаваме на следващият инструмент
                currentTool=tools.iterator().next();
            }
        }

    }
}
