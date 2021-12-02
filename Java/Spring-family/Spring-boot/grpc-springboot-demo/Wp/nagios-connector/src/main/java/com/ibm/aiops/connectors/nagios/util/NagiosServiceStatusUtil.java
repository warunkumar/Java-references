package com.ibm.aiops.connectors.nagios.util;

import com.ibm.aiops.connectors.nagios.constants.NagiosServiceConstants;
import com.ibm.aiops.connectors.nagios.dto.ServiceStatusDto;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Filters the Input Data into a Map of Required Metrics
 *
 * @author Pola Vamsi Rahul
 * @createdOn 09-11-2021
 */
@UtilityClass
public class NagiosServiceStatusUtil {
  /**
   * @param serviceStatusDto - Input Raw Metrics
   * @return - A map of Filtered Metrics
   */
  public Map<String, List<ServiceStatusDto.Servicestatus>> processFilterServiceStatusMetrics(
      ServiceStatusDto serviceStatusDto) {

    Map<String, List<ServiceStatusDto.Servicestatus>> statusMap = new HashMap<>();
    List<ServiceStatusDto.Servicestatus> diskStatusList = null;
    List<ServiceStatusDto.Servicestatus> cpuStatusList = null;
    List<ServiceStatusDto.Servicestatus> memoryStatusList = null;
    List<ServiceStatusDto.Servicestatus> swapStatusList = null;

    if (serviceStatusDto.getServicestatus().size() > 0) {
      diskStatusList = new ArrayList<>();
      cpuStatusList = new ArrayList<>();
      memoryStatusList = new ArrayList<>();
      swapStatusList = new ArrayList<>();
    }
    for (ServiceStatusDto.Servicestatus servicestatus : serviceStatusDto.getServicestatus()) {
      if (servicestatus.getCheckCommand().contains(NagiosServiceConstants.CHECK_XI_NCPA)
              && (servicestatus.getCheckCommand().contains(NagiosServiceConstants.DISK_LOGICAL_LINUX)
              || servicestatus
              .getCheckCommand()
              .contains(NagiosServiceConstants.DISK_LOGICAL_WINDOWS))) {
        diskStatusList.add(servicestatus);
      }

      else if (servicestatus.getCheckCommand().contains(NagiosServiceConstants.CHECK_XI_NCPA)
              && servicestatus.getCheckCommand().contains(NagiosServiceConstants.MEMORY_VIRTUAL)) {
        memoryStatusList.add(servicestatus);
      }

      else if (servicestatus.getCheckCommand().contains(NagiosServiceConstants.CHECK_XI_NCPA)
              && servicestatus.getCheckCommand().contains(NagiosServiceConstants.CPU_PERCENT)) {
        cpuStatusList.add(servicestatus);
      }
      else if (servicestatus.getCheckCommand().contains(NagiosServiceConstants.CHECK_XI_NCPA)
              && servicestatus.getCheckCommand().contains(NagiosServiceConstants.MEMORY_SWAP)) {
        swapStatusList.add(servicestatus);
      }
    }

    statusMap.put(NagiosServiceConstants.DISK_USAGE, diskStatusList);
    statusMap.put(NagiosServiceConstants.CPU_USAGE, cpuStatusList);
    statusMap.put(NagiosServiceConstants.MEMORY_USAGE, memoryStatusList);
    statusMap.put(NagiosServiceConstants.SWAP_USAGE, swapStatusList);

    return statusMap;
  }
}
