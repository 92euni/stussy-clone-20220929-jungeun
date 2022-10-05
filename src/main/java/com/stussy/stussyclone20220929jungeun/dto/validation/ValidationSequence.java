package com.stussy.stussyclone20220929jungeun.dto.validation;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

@GroupSequence({Default.class, ValidationGroups.NotBlankGroup.class, ValidationGroups.PatternCheckGroup.class})
//왼쪽 부터 우선순위다!

public interface ValidationSequence {
}
