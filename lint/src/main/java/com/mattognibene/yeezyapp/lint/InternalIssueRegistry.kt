package com.mattognibene.yeezyapp.lint

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.Issue

/**
 * Custom Lint issue registry for com.mattognibene.yeezyapp.
 */
class InternalIssueRegistry : IssueRegistry() {
    override val issues: List<Issue>
        get() = listOf(
                ISSUE_TODO,
                ISSUE_INVALID_IMPORT,
                ISSUE_NAMING_PATTERN,
                ISSUE_DEFAULT_LAYOUT_ATTRIBUTE
        )

    override val api: Int = com.android.tools.lint.detector.api.CURRENT_API
}