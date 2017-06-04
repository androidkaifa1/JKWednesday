package cn.itcast.jk.controller.cargo.packingList;

import cn.itcast.jk.controller.BaseController;
import cn.itcast.jk.domain.PackingList;
import cn.itcast.jk.service.PackingListService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by root on 2017/6/3.
 */
@Controller
public class PackingListController extends BaseController {
    @Resource
    PackingListService packingListService;

    @RequestMapping("/cargo/packinglist/list.action")
    public String list(Model model){
        List<PackingList> dataList = packingListService.find(null);
        model.addAttribute("dataList", dataList);

        return "/cargo/packinglist/JPackingListList.jsp";
    }

    @RequestMapping("/cargo/packinglist/tocreate.action")
    public String tocreate(String[] id,Model model){//出口报运的ID集合

        //携带出口报运ID集合,显示装箱和报运的关系
       model.addAttribute("divData", packingListService.getDivDataCreate(id));

        return "/cargo/packinglist/JPackingListCreate.jsp";
    }

    @RequestMapping("/cargo/packinglist/insert.action")
    public String insert(PackingList packingList){

       packingListService.insert(packingList);

        return "redirect:/cargo/packinglist/list.action";
    }

    @RequestMapping("/cargo/packinglist/toupdate.action")
    public String toupdate(String id, Model model){
        PackingList obj = packingListService.get(id);
        model.addAttribute("obj",obj);

        String _s = packingListService.getDivDataUpdate(obj.getExportIds().split("\\|"), obj.getExportNos().split("\\|"));
        model.addAttribute("divData", _s);

        return "/cargo/packinglist/JPackingListUpdate.jsp";
    }

    @RequestMapping("/cargo/packinglist/update.action")
    public String update(PackingList packingList){
        packingListService.update(packingList);

        return "redirect:/cargo/packinglist/list.action";
    }

    @RequestMapping("/cargo/packinglist/toview.action")
    public String toview(String id,Model model){
        PackingList obj = packingListService.get(id);
        model.addAttribute("obj", obj);

        model.addAttribute("divData", packingListService.getDivDataView(obj.getExportNos().split("\\|")));

        return "/cargo/packinglist/JPackingListView.jsp";
    }
}


















