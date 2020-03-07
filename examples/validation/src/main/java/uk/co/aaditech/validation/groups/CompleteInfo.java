package uk.co.aaditech.validation.groups;

import javax.validation.GroupSequence;

@GroupSequence({ BasicInfo.class, AdvanceInfo.class })
public interface CompleteInfo {

}