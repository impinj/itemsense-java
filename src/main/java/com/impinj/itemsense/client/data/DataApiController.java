package com.impinj.itemsense.client.data;

import com.impinj.itemsense.client.data.item.ItemController;
import com.impinj.itemsense.client.data.itemhistory.ItemHistoryController;
import com.impinj.itemsense.client.data.itemthresholdtransition.ItemThresholdTransitionController;
import com.impinj.itemsense.client.helpers.ObjectMapperContextResolver;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;


public class DataApiController {

  private final ObjectMapperContextResolver OBJECT_MAPPER_CONTEXT_RESOLVER
      = new ObjectMapperContextResolver();

  private ItemController itemController;
  private ItemHistoryController itemHistoryController;
  private ItemThresholdTransitionController itemThresholdTransitionController;
  private WebTarget target;

  public DataApiController(final Client client, final URI uri) {
    this.target = client.register(OBJECT_MAPPER_CONTEXT_RESOLVER).target(uri);

    this.itemController = new ItemController(target);
    this.itemHistoryController = new ItemHistoryController(target);
    this.itemThresholdTransitionController = new ItemThresholdTransitionController(target);
  }

  public ObjectMapperContextResolver getOBJECT_MAPPER_CONTEXT_RESOLVER() {return this.OBJECT_MAPPER_CONTEXT_RESOLVER;}

  public ItemController getItemController() {return this.itemController;}

  public ItemHistoryController getItemHistoryController() {return this.itemHistoryController;}

  public ItemThresholdTransitionController getItemThresholdTransitionController() {return this.itemThresholdTransitionController;}

  public WebTarget getTarget() {return this.target;}

  public void setItemController(ItemController itemController) {this.itemController = itemController; }

  public void setItemHistoryController(ItemHistoryController itemHistoryController) {this.itemHistoryController = itemHistoryController; }

  public void setItemThresholdTransitionController(ItemThresholdTransitionController itemThresholdTransitionController) {this.itemThresholdTransitionController = itemThresholdTransitionController; }

  public void setTarget(WebTarget target) {this.target = target; }

  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof DataApiController)) {
      return false;
    }
    final DataApiController other = (DataApiController) o;
    final Object this$OBJECT_MAPPER_CONTEXT_RESOLVER = this.getOBJECT_MAPPER_CONTEXT_RESOLVER();
    final Object other$OBJECT_MAPPER_CONTEXT_RESOLVER = other.getOBJECT_MAPPER_CONTEXT_RESOLVER();
    if (this$OBJECT_MAPPER_CONTEXT_RESOLVER == null ? other$OBJECT_MAPPER_CONTEXT_RESOLVER != null
                                                    : !this$OBJECT_MAPPER_CONTEXT_RESOLVER.equals(
                                                        other$OBJECT_MAPPER_CONTEXT_RESOLVER)) {
      return false;
    }
    final Object this$itemController = this.getItemController();
    final Object other$itemController = other.getItemController();
    if (this$itemController == null ? other$itemController != null : !this$itemController.equals(
        other$itemController)) {
      return false;
    }
    final Object this$itemHistoryController = this.getItemHistoryController();
    final Object other$itemHistoryController = other.getItemHistoryController();
    if (this$itemHistoryController == null ? other$itemHistoryController != null
                                           : !this$itemHistoryController.equals(
                                               other$itemHistoryController)) {
      return false;
    }
    final Object this$itemThresholdTransitionController = this
        .getItemThresholdTransitionController();
    final Object other$itemThresholdTransitionController = other
        .getItemThresholdTransitionController();
    if (this$itemThresholdTransitionController == null ? other$itemThresholdTransitionController
        != null : !this$itemThresholdTransitionController.equals(
        other$itemThresholdTransitionController)) {
      return false;
    }
    final Object this$target = this.getTarget();
    final Object other$target = other.getTarget();
    return this$target == null ? other$target == null : this$target.equals(other$target);
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $OBJECT_MAPPER_CONTEXT_RESOLVER = this.getOBJECT_MAPPER_CONTEXT_RESOLVER();
    result = result * PRIME + ($OBJECT_MAPPER_CONTEXT_RESOLVER == null ? 43
                                                                       : $OBJECT_MAPPER_CONTEXT_RESOLVER
                                   .hashCode());
    final Object $itemController = this.getItemController();
    result = result * PRIME + ($itemController == null ? 43 : $itemController.hashCode());
    final Object $itemHistoryController = this.getItemHistoryController();
    result =
        result * PRIME + ($itemHistoryController == null ? 43 : $itemHistoryController.hashCode());
    final Object $itemThresholdTransitionController = this.getItemThresholdTransitionController();
    result = result * PRIME + ($itemThresholdTransitionController == null ? 43
                                                                          : $itemThresholdTransitionController
                                   .hashCode());
    final Object $target = this.getTarget();
    result = result * PRIME + ($target == null ? 43 : $target.hashCode());
    return result;
  }

  public String toString() {
    return "com.impinj.itemsense.client.data.DataApiController(OBJECT_MAPPER_CONTEXT_RESOLVER="
        + this.getOBJECT_MAPPER_CONTEXT_RESOLVER() + ", itemController=" + this.getItemController()
        + ", itemHistoryController=" + this.getItemHistoryController()
        + ", itemThresholdTransitionController=" + this.getItemThresholdTransitionController()
        + ", target=" + this.getTarget() + ")";
  }
}
